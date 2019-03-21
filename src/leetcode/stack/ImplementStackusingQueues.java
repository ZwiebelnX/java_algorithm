package leetcode.stack;

import offer.ImplementQueueUsingStacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackusingQueues {
    public static void main(String[] args){
        ImplementStackusingQueues stack = new ImplementStackusingQueues();
        stack.stack.push(0);
        stack.stack.push(1);
        stack.stack.push(2);
        stack.stack.pop();
        stack.stack.pop();
        boolean empty = stack.stack.empty();
        stack.stack.pop();
        empty = stack.stack.empty();


    }

    public MyStack stack = new MyStack();

    public class MyStack {
        private int size = 0;
        private Queue<Integer> queue = new ArrayDeque<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            size++;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(size != 0){
                for(int i = 0; i < size - 1; i++){
                    queue.offer(queue.poll());
                }
            }
            size--;
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            if(size != 0){
                for(int i = 0; i < size - 1; i++){
                    queue.offer(queue.poll());
                }
            }
            int result = queue.peek();
            queue.offer(queue.poll());
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return size == 0;
        }
    }
}
