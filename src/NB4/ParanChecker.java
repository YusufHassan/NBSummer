package NB4;
import java.util.*;

public class ParanChecker{
    public static boolean checkBalanced(String input) {
        int openParaCounter = 0;
        int closeParaCounter = 0;
        boolean isBalanced;
        Deque<Character> list = new ArrayDeque<>(10);
        char[] chars = input.toCharArray();
        for (char c: chars) {
            if(c == '(' || c == ')')
                list.offer(c);
        }
        while(list.size()>0){
            if(openParaCounter == closeParaCounter && list.peekFirst() == ')')
                return false;
            char hold1 = list.pollFirst();
            char hold2 = list.pollFirst();
            if(hold1 == '(')
                openParaCounter++;
            if(hold2 == ')')
                closeParaCounter++;
        }
        return openParaCounter == closeParaCounter && closeParaCounter != 0;
    }
    public static void main(String[] args){
        System.out.println(ParanChecker.checkBalanced(""));
    }
}
