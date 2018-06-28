package Föreläsning6;

import java.util.LinkedList;
import java.util.Queue;

public class FreakyElevator {
    private static class Tillstand{
        public int position,antalResor;
        public Tillstand(int p, int a){
            position=p;
            antalResor=a;
        }
    }
    public static int antalResorBredd(int n, int upp, int ned, int destination){
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(1,0);
        while(t.position!=destination){
            if(t.position+upp <=n)
                q.offer(new Tillstand(t.position+upp,t.antalResor+1));
            if(t.position-ned >=1)
                q.offer(new Tillstand(t.position-ned,t.antalResor+1));
            t = q.poll();
        }
        return t.antalResor;
    }
    public static int antalResorHiss(int n, int upp, int ned,int position,int destination, int antalResor){
        if(position == destination)
            return antalResor;
        else if(antalResor > 30)
            return Integer.MAX_VALUE;
        int alternativ1 =  antalResorHiss(n,upp,ned,position+upp,destination,antalResor+1);
        int alternativ2 = antalResorHiss(n,upp,ned,position-ned,destination,antalResor+1);
        if(alternativ1 == alternativ2)
            return alternativ1;
        if(alternativ1 < alternativ2)
            return alternativ1;
        else
            return alternativ2;

    }
    public static int wrapper(int n, int upp, int ned, int destination){
        return antalResorHiss(n,upp,ned,1,destination,0);
    }
    public static void main(String[] args){
        System.out.println(wrapper(78,15,8,35));
        System.out.println(antalResorBredd(78,15,8,35));
    }
}
