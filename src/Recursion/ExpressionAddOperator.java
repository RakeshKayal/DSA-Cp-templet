package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class ExpressionAddOperator {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;

        List<String> list = addOperators(num, target);

        System.out.println(list);


    }
    static List<String > ans;
    static  String  sign="+-*";
    public  static List<String> addOperators(String num, int target) {
        ans= new ArrayList<>();


        StringBuilder sb= new StringBuilder();
        f(0,num,sb,target);
        return  ans;

    }

    private static void f(int i, String num, StringBuilder sb, int target) {
        if (i==num.length()){
            System.out.println(sb.toString());
            if (evaluate(sb.toString())==target){
                 //add
                ans.add(sb.toString());
            }
            return;
        }

        char digit = num.charAt(i);
        if (i==0) {
            sb.append(digit);
            f(i + 1, num, sb, target);
            sb.deleteCharAt(sb.length() - 1);
        }else {

            for (int j = 0; j < 3; j++) {
                sb.append(sign.charAt(j));
                sb.append(digit);
                f(i + 1, num, sb, target);
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);

            }
        }

    }

    private static long evaluate(String expr) {
        Stack<Long> stack = new Stack<>();
        long num = 0;
        char lastSign = '+';  // treat start as if there's a + before first number

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // build the number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // when we hit a sign OR end of string → process previous number
            if (!Character.isDigit(c) || i == expr.length() - 1) {
                if (lastSign == '+') {
                    stack.push(num);          // push positive
                } else if (lastSign == '-') {
                    stack.push(-num);         // push negative
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);  // multiply with top
                }
                lastSign = c;  // update sign
                num = 0;       // reset number
            }
        }

        // sum everything in stack
        long result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


}
