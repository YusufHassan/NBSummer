package NB12;

public class Npower {
    public static int power(int x, int n, int count){
        if(count == n){
            count++;
            return x;
        }
        else{
            count++;
            return  power(x,n,count) * x;  // B
        }
    }
    public static void main(String[] args){
        System.out.println(Npower.power(3,3,1)); // A
    }
}
