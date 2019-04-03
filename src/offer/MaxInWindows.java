package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题59
 */
public class MaxInWindows {
    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{16,14,12,10,8,6,4}, 5));
    }

    private static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length < size || size <= 0) return result;

        Deque<Integer> queue = new LinkedList<>();
        // 初始化队列
        for(int i = 0; i < size; i++){
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for(int i = size; i < num.length; i++){
            result.add(num[queue.peekFirst()]); //将上一个窗口的最大值加入结果

            //除去队尾开始比当前元素小的元素的下标
            while(!queue.isEmpty() && num[i] >= num[queue.peekLast()])
                queue.pollLast();
            //如果当前出窗口的是最大值，将他弹出队列
            if(!queue.isEmpty() && queue.peekFirst() <= (i - size))
                queue.pollFirst();

            //将自己加入双端队列
            queue.offerLast(i);
        }
        //将最后一个窗口的结果加入结果中
        result.add(num[queue.peekFirst()]);
        return result;
    }
}
