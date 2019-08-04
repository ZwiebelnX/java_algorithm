package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Title: LastStoneWeight</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class LastStoneWeight {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();
            int diff = Math.abs(x - y);
            if (diff != 0) {
                queue.offer(diff);
            }
        }
        if(queue.isEmpty()) return 0;
        else return queue.peek();
    }
}
