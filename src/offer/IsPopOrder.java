package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题31
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(push, pop));
    }

    private static boolean isPopOrder(int[] pushA, int[] popA) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pushPointer = 0;
        int popPointer = 0;
        stack.offerFirst(pushA[0]);
        while (popPointer < popA.length) {
            if (stack.isEmpty() || stack.peek() != popA[popPointer]) {
                pushPointer++;
                if (pushPointer >= pushA.length) return false;
                stack.offerFirst(pushA[pushPointer]);
            } else {
                stack.poll();
                popPointer++;
            }
        }
        return true;
    }
}
