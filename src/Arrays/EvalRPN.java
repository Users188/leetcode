package Arrays;
/*leetcode:后缀表达式*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvalRPN {
    public  int evalRPN(String[] tokens){
        Set<String> operators= Stream.of("+","-","*","/").collect(Collectors.toSet());
        //数字的数量比操作符多一，即总量的（1/2+1), 预先分配好空间可以减少扩容的时间
        Deque<Integer> stack=new ArrayDeque<>(tokens.length/2+1);
        for(String token:tokens){
            if (operators.contains(token)){
                int b=stack.pop();
                int a=stack.pop();
                stack.push(operate(token,a,b));
            }
            else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    private int operate(String operator,int a,int b){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                throw new ArithmeticException("no such operator");
        }
    }

    public static void main(String[] args) {
        String[] tokens= new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }

}
