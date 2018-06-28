package NB15;
import java.lang.Math;
public class BinaryConverter {
    public static int wrapper(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return converter(sb.reverse().toString(),0,0);
    }
    public static int converter(String s, int answer,int count){
        if(count == s.length())
            return answer;
        if(s.charAt(count)=='1') {
            answer += Math.pow(2, count);
            count++;
            return converter(s,answer,count);
        }
        else{
            answer += 0;
            count++;
            return converter(s,answer,count);
        }
    }
    public static void main(String[] args){
        System.out.println(BinaryConverter.wrapper("0101"));
    }
}
