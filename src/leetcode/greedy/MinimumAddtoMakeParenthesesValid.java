package leetcode.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * questionIndex: 921
 */
public class MinimumAddtoMakeParenthesesValid {
    public static void main(String[] args){
        System.out.println(minAddToMakeValid("(((((((("));
    }

    private static int minAddToMakeValid(String S) {
        Deque<Character> charStack = new ArrayDeque<>();
        for(int i = S.length() - 1; i >= 0; i--){
            char s = S.charAt(i);
            if(s == ')'){
                charStack.addFirst(s);
            }
            if(s == '('){
                if(charStack.size() != 0 && charStack.peek() == ')'){
                    charStack.poll();
                }
                else{
                    charStack.addFirst(s);
                }
            }
        }
        return charStack.size();
    }
}
