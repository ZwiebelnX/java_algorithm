package offer;

import java.util.ArrayList;

/**
 * 面试题57
 * 题目1
 */
public class FindNumbersWithSum {
    public static void main(String[] args){
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(array, 15));
    }

    private static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        int low = 0;
        int high = array.length - 1;
        while (low < high){
            int tempSum = array[low] + array[high];
            if(tempSum == sum){
                ArrayList<Integer> result = new ArrayList<>();
                result.add(array[low]);
                result.add(array[high]);
                return result;
            }
            if(tempSum < sum) low++;
            else high--;
        }
        return new ArrayList<>();
    }
}
