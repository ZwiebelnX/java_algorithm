package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueusingStacks {
    private class MyQueue {
        private Deque<Integer> output;
        private Deque<Integer> intput;

        private void reverse(String s){
            if(s.equals("in")){
                if(intput.size() == 0){
                    while (output.size() != 0){
                        intput.offerFirst(output.poll());
                    }
                }
            }
            else{
                if(output.size() == 0){
                    while (intput.size() != 0){
                        output.offerFirst(intput.poll());
                    }
                }
            }
        }

        /** Initialize your data structure here. */
        public MyQueue() {
            output = new LinkedList<>();
            intput = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            reverse("in");
            intput.offerFirst(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            reverse("out");
            return output.poll();
        }

        /** Get the front element. */
        public int peek() {
            reverse("out");
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return intput.size() == 0 && output.size() == 0;
        }
    }

    public static void main(String[] args){
        System.out.println(Math.pow(3, 6) % 11);
    }
}
