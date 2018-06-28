package NB14;

public class CoinMachine {
    public static int counter(int points,int goalPoints, int costs){

        if(points == goalPoints){
            System.out.println(points);
            System.out.println(goalPoints);
            return costs;
        }
        else if(points > goalPoints){
            return Integer.MAX_VALUE;
        }
        int costA = counter(points*3,goalPoints,costs+10);
        int costB = counter(points+4,goalPoints,costs+5);

        if(costA < costB)
            return costA;
        if(costA > costB)
            return costB;
        if(costA == costB)
            return costB;
       return  Integer.MIN_VALUE;
    }
    public static void main(String[] args){
        System.out.println(CoinMachine.counter(1,79,0)+"klar");
    }
}
