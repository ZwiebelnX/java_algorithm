package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * questionIndex: 155
 */
public class MinStack {
    public static void main(String[] args){
        MinStack minStack1 = new MinStack();
        minStack1.push(1);
        minStack1.push(0);
        minStack1.push(2);
        minStack1.push(3);
        int min = minStack1.getMin();
        minStack1.pop();
        minStack1.pop();
        int top = minStack1.top();
        minStack1.pop();
        min = minStack1.getMin();
        System.exit(0);
    }

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.offerFirst(x);
        if(minStack.isEmpty() || minStack.peek() >= x) minStack.offerFirst(x);
    }

    public void pop() {
        int popNum = stack.poll();
        if(popNum == minStack.peek()) minStack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
