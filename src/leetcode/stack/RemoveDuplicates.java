package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * <p>Title: RemoveDuplicates</p>
 * <p>Description: 1047</p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 * @date 2019/7/13 13:23
 */
public class RemoveDuplicates {
    public static void main(String[] args){
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < S.length(); i++){
            if(stack.isEmpty() || stack.getFirst() != S.charAt(i)) stack.addFirst(S.charAt(i));
            else{
                stack.poll();
            }
        }

        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = stack.descendingIterator();
        while (iterator.hasNext()){
            result.append(iterator.next());
        }

        return result.toString();
    }
}
