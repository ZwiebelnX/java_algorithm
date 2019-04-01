package offer;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 面试题40
 */
public class GetLeastNumbers {
    public static void main(String[] args){
        getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
    }

    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0 || k <= 0 || k > input.length){
            return result;
        }

        TreeSet<Integer> bucket = new TreeSet<>();
        int max = Integer.MIN_VALUE;

        for (int i : input) {
            if(bucket.size() < k){
                bucket.add(i);
                max = bucket.last();
            }
            else if(i < max){
                bucket.pollLast();
                bucket.add(i);
                max = bucket.last();
            }
        }
        result.addAll(bucket);
        return result;
    }
}
