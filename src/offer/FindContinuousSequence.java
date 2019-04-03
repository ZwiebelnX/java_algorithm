package offer;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * 面试题57
 * 题目2
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
    }

    private static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) return result;

        int low = 1;
        int high = 2;
        int mid = (1 + sum) / 2;    //当low超过mid后，一定不会有结果输出
        int curSum = low + high;

        while (low < mid) {

            while (curSum > sum && low < mid) {     //当当前的和大于sum时，不断去掉队尾较小的数
                curSum -= low;
                low++;
            }

            if (curSum == sum) {
                ArrayList<Integer> seq = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    seq.add(i);
                }
                result.add(seq);
            }

            //队头向前走，寻找子数组
            high++;
            curSum += high;

        }
        return result;
    }
}
