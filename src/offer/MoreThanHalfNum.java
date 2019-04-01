package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39
 */
public class MoreThanHalfNum {
    public static void main(String[] args){
        int[] array = {1,2,3,2,4,2,5,2,3};
        moreThanHalfNum(array);
    }

    private static int moreThanHalfNum(int[] array){
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : array) {
            countMap.merge(i, 1, (v, value) -> v = value + v);
        }
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            if(integerIntegerEntry.getValue() > max){
                max = integerIntegerEntry.getValue();
                result = integerIntegerEntry.getKey();
            }

        }
        if(max < (double)array.length / 2) return 0;
        else return result;
    }
}
