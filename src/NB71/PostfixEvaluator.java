package NB71;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class PostfixEvaluator {
    public final ArrayList<Character> OPERATORS;
    public PostfixEvaluator(){
        OPERATORS = new ArrayList<>(4);
        OPERATORS.add('+');
        OPERATORS.add('-');
        OPERATORS.add('*');
        OPERATORS.add('/');
    }
    private class WrongFormatException extends RuntimeException{
        public WrongFormatException(String msg){
            super(msg);
        }
    }
    public int eval(String input){
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = input.split(" ");
        int leftOperand = 0;
        int rightOperand = 0;
        int count = 0;
        int res = 0;
        for (String s: tokens) {
            if(Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt((s)));
                count++;
            }
            if(count > 2)
                throw new WrongFormatException("Please enter correct format.");
            else if(OPERATORS.contains(s.charAt(0))){
                if(stack.isEmpty())
                    throw new WrongFormatException("Please enter correct format.");
                 rightOperand = stack.pop();
                if(stack.isEmpty())
                    throw new WrongFormatException("Please enter correct format.");
                 leftOperand = stack.pop();
                 switch(s.charAt(0)){
                     case '*':
                        res = leftOperand * rightOperand;
                        break;
                     case '/':
                         res = leftOperand / rightOperand;
                         break;
                     case '+':
                         res = leftOperand + rightOperand;
                         break;
                     case '-':
                         res = leftOperand - rightOperand;
                         break;
                     default:
                         System.out.println("We should never get here");
                 }
                 count = 0;
                 stack.push(res);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        PostfixEvaluator calc = new PostfixEvaluator();
        System.out.println(calc.eval("10 23 + -"));
    }
}
