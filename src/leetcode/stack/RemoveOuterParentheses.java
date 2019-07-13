package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Title: RemoveOuterParentheses</p>
 * <p>Description: 1021</p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 * @date 2019/7/11 20:47
 */
public class RemoveOuterParentheses {
    public static void main(String[] args){
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        int stack = 0;
        StringBuilder result = new StringBuilder();

        int head = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(') stack++;
            if(S.charAt(i) == ')') stack--;
            if(stack == 0){
                result.append(S, head + 1, i);
                head = i + 1;
            }
        }
        return result.toString();
    }
}
