package offer;

import java.util.Arrays;

/**
 * 面试题61
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] numbers = {0,3,2,6,4};
        System.out.println(isContinuous(numbers));
    }

    private static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        Arrays.sort(numbers);

        int zeroCount = 0;
        int curNum = -1;
        for (int number : numbers) {
            if (number == 0) zeroCount++;
            else {
                if (curNum == -1) curNum = number;
                else{
                    if (curNum + 1 != number) {
                        if(curNum == number) return false;
                        if((number - curNum - 1) <= zeroCount) zeroCount -= (number - curNum - 1);
                        else return false;
                    }
                    curNum = number;
                }
            }
        }

        return true;
    }
}
