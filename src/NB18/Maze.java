package NB18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    int rows, columns;

    public enum Cell {WALL, OPEN, CORRECT, VISITED}

    ;
    private Position currentP, goal;
    Cell[][] mazeMatrix;


    public Maze() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/NB18/Labyrint.txt"));
            rows = Integer.parseInt(in.readLine()) + 2;
            columns = Integer.parseInt(in.readLine()) + 2;
            mazeMatrix = new Cell[rows][columns];
            for (int j = 0; j < columns; j++) {
                mazeMatrix[0][j] = Cell.WALL;
                mazeMatrix[rows - 1][j] = Cell.WALL;
            }
            for (int i = 1; i < rows - 1; i++) {
                mazeMatrix[i][0] = Cell.WALL;
                mazeMatrix[i][columns - 1] = Cell.WALL;
            }
            for (int i = 1; i < rows - 1; i++) {
                String s = in.readLine();
                for (int j = 1; j < columns - 1; j++) {
                    mazeMatrix[i][j] = Cell.OPEN;
                    if (s.charAt(j - 1) == '*')
                        mazeMatrix[i][j] = Cell.WALL;
                    else if (s.charAt(j - 1) == 'g') {
                        goal = new Position(i, j);
                    } else if (s.charAt(j - 1) == 's') {
                        currentP = new Position(i, j);
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private class Position {
        int row, column;

        public Position(int r, int c) {
            row = r;
            column = c;
        }

        public boolean equals(Position p) {
            return (row == p.row && column == p.column);
        }
    }

    public boolean solve() {
        return solve(currentP);
    }

    private boolean solve(Position p) {
        if (p.equals(goal)){
            System.out.println("???");
            return true;
        }

        else {
            mazeMatrix[p.row][p.column] = Cell.CORRECT;
            if (mazeMatrix[p.row - 1][p.column].ordinal() == 1) {
                if (solve(new Position(p.row - 1, p.column))) // testa upp
                    return true;
            } if (mazeMatrix[p.row][p.column + 1].ordinal() == 1) {
                if (solve(new Position(p.row, p.column + 1))) // testa höger
                    return true;
            }
             if (mazeMatrix[p.row][p.column - 1].ordinal() == 1) {
                if (solve(new Position(p.row, p.column - 1))) // testa vänster
                    return true;
            } if (mazeMatrix[p.row + 1][p.column].ordinal() == 1) {
                if (solve(new Position(p.row + 1, p.column))) // testa ner
                    return true;
            }

            mazeMatrix[p.row][p.column] = Cell.VISITED;
            /*for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < columns - 1; j++)
                    if (mazeMatrix[i][j].ordinal() == 1)
                        System.out.print(ANSI_CYAN + mazeMatrix[i][j].ordinal() + ANSI_RESET); Kommentera in denna kod om du vill se backtracking med dina egna ögon.
                    else
                        System.out.print(mazeMatrix[i][j].ordinal());
                System.out.println();
            }*/
            System.out.println();
            return false;
        }
    }

    public void print() {
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++)
                if (mazeMatrix[i][j].ordinal() == 1)
                    System.out.print(ANSI_CYAN + mazeMatrix[i][j].ordinal() + ANSI_RESET);
                else
                    System.out.print(mazeMatrix[i][j].ordinal());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        m.print();
        if (m.solve()) System.out.println("Lyckades");
        System.out.println();
        m.print();
    }

}
