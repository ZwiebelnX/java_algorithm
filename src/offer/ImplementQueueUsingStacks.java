package offer;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {
    private Deque<Integer> in = new LinkedList<>();
    private Deque<Integer> out = new LinkedList<>();

    public void push(int node){
        while (!out.isEmpty()){
            in.offerFirst(out.poll());
        }
        in.offerFirst(node);
    }

    public int pop(){
        while (!in.isEmpty()){
            out.offerFirst(in.poll());
        }
        return out.poll();
    }

    public static void main(String[] args){
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
