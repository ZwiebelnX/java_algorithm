package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * questionIndex: 20
 */
public class ValidParentheses {
    public static void main(String[] args){
        String s = "{{{]]]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.offerFirst(c);
            }
            else{
                if(!stack.isEmpty()){
                    switch (c){
                        case '}':
                            if(stack.peek() == '{'){
                                stack.poll();
                                break;
                            }
                            else return false;
                        case ')':
                            if(stack.peek() == '('){
                                stack.poll();
                                break;
                            }
                            else return false;
                        case ']':
                            if(stack.peek() == '['){
                                stack.poll();
                                break;
                            }
                            else return false;
                    }
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
