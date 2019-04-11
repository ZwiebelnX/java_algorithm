package offer;


import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianInStream {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public static void main(String[] args){
    }

    private void insert(Integer num){//当数据总数为偶数时，新加入的元素，应当进入小根堆
        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
        //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
        if(count % 2 == 0){
            maxHeap.offer(num);
            int filteredMax = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMax);
        }
        else{//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMin = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMin);
        }
        count++;
    }

    private Double GetMedian() {
        if(count % 2 == 0){
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        }
        else{
            return (double)minHeap.peek();
        }
    }
}
