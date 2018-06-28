package NB16;

import java.util.LinkedList;
import java.util.Queue;

public class CoinMachineWidth {
    private static class Tillstand{
        private int points;
        private int cost;
        public Tillstand(int points, int cost){
            this.points = points;
            this.cost = cost;
        }
    }
    public static int coinMachine(int goal){
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(1,0);
        while(t.points!=goal){
                q.offer(new Tillstand(t.points+4,t.cost+5));
                q.offer(new Tillstand(t.points*3,t.cost+10));
                t = q.poll();
        }
        System.out.println(t.points);
        return t.cost;
    }
    public static void main(String[] args){
        System.out.println(coinMachine(109));
    }
}
