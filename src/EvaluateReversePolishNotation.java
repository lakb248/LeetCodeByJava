package solution;

import java.util.Stack;

/**
 * Created by lakb2_000 on 2014/10/22.
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args){
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation() ;
        System.out.print(eval.evalRPN(new String[]{"0","3","/"}));
    }

    public int evalRPN(String[] tokens) {
        int result = 0 ;
        Stack<String> stack = new Stack<String>() ;
        int length = tokens.length ;
        for(int i = 0 ; i < length ; i ++){
            String temp = tokens[i] ; int a = 0 , b = 0 ;
            if(temp == "/") {

                a = Integer.valueOf(stack.pop());
                b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b/a));

            }else if(temp == "*"){

                a = Integer.valueOf(stack.pop()) ;
                b = Integer.valueOf(stack.pop()) ;
                stack.push(String.valueOf(a*b)) ;

            }else if(temp == "+"){

                a = Integer.valueOf(stack.pop()) ;
                b = Integer.valueOf(stack.pop()) ;
                stack.push(String.valueOf(a+b)) ;

            }else if(temp == "-"){

                a = Integer.valueOf(stack.pop()) ;
                b = Integer.valueOf(stack.pop()) ;
                stack.push(String.valueOf(b-a)) ;

            }else{

                stack.push(temp) ;

            }
        }

        result = Integer.valueOf(stack.pop()) ;

        return result ;
    }

}
