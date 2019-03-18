package leetcode.stack;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * questionIndex: 682
 */
public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }

    private static int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        int total = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    total -= stack.poll();
                    break;
                case "D":
                    stack.offerFirst(stack.peek() * 2);
                    total += stack.peek();
                    break;
                case "+":
                    int point = stack.poll();
                    int sum = point + stack.peek();
                    total += sum;
                    stack.offerFirst(point);
                    stack.offerFirst(sum);
                    break;
                default:
                    stack.offerFirst(Integer.parseInt(op));
                    total += Integer.parseInt(op);
            }
        }
        return total;
    }
}
