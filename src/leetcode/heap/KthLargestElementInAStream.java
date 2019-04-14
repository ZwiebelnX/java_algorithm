package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static void main(String[] args){

    }

    private int k;
    private int[] nums;
    private PriorityQueue<Integer> minHeap;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }


    }

    public int add(int val) {
        if(minHeap.size() < k) minHeap.offer(val);
        else if(minHeap.peek() == null || val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }


}
