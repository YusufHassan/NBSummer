package NB15;
import java.lang.Math;
import java.math.BigInteger;

public class BinaryConverter {
    public static int wrapperBinaryConverter(String s){
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
    public static String wrapperDecimalToBinary(Integer number){
        StringBuilder sb = new StringBuilder();
        sb.append(decimalToBinary("",0,new BigInteger(number.toString())));
        return sb.reverse().toString();
    }
    public static String decimalToBinary(String answer, int count, BigInteger number){
        if((number.divideAndRemainder(new BigInteger("2"))[0]).intValue() == 0 && count ==1)
            return answer;
        else{
            if((number.divideAndRemainder(new BigInteger("2"))[0]).intValue() == 0)
                count++;
            answer += number.divideAndRemainder(new BigInteger("2"))[1].toString();
            number = number.divideAndRemainder(new BigInteger("2"))[0];
            return decimalToBinary(answer,count,number);
        }
    }
    public static void main(String[] args){
        System.out.println(BinaryConverter.wrapperBinaryConverter("11101"));
        System.out.println(wrapperDecimalToBinary(11));
    }
}
