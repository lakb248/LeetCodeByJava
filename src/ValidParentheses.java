package solution;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
        System.out.print(Integer.valueOf('{'));
		ValidParentheses valid = new ValidParentheses() ;
        System.out.print(valid.isValid("([)]"));
	}
	//考虑遍历字符串后，栈中还有字符以及在遍历过程中栈因为前面的符号都匹配了而变为空
	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>() ;
        int leftBracket = 40 , rightBracket = 41 , leftSquareBracket = 91 , rightSquareBracket = 93 ,
            leftBigBracket = 123 , rightBigBracket = 125 ;
		int length = s.length() ;
		char cur ;
		for(int i = 0 ; i < length ; i ++){
			cur = s.charAt(i) ;
			if(cur == leftBracket || cur == leftSquareBracket || cur == leftBigBracket){
				stack.push(Integer.valueOf(cur)) ;
			}else {
                if(stack.size() == 0){
                    return false ;
                }else{
                    int top = stack.peek() ;
                    if(cur == rightBracket && top == leftBracket)
                        stack.pop() ;
                    else if(cur == rightBigBracket && top == leftBigBracket)
                        stack.pop() ;
                    else if(cur == rightSquareBracket && top ==leftSquareBracket)
                        stack.pop() ;
                    else{
                        return false ;
                    }
                }
            }
		}

        if(stack.size() != 0)
            return false ;
		return true ;
    }
}
