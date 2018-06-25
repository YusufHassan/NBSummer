package NB13;
import java.lang.Math;
public class RootCalculator {
    public static double root(double n, double a, double e){
        if(Math.abs(Math.pow(a,2)-n) < e)
            return a;
        else{
            return root(n,((Math.pow(a,2) + n)/(2 *a)),e);
        }
    }
    public static void main(String[] args){
        System.out.println(RootCalculator.root(25,1,0.00001));
    }
}
