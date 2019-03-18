package leetcode.dp;

import java.util.Arrays;

/**
 * questionIndex: 338
 */
public class CountingBits {

    public static void main(String[] args){
        int num = 10;
        Arrays.stream(countBits(num)).forEach(System.out::println);
    }

    private static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for(int i = 1; i <= num; i++){
            // 这个好像是总结出来的，没太懂
            // result[i] = result[i & (i - 1)] + 1;
            // or
            // 偶数和右移一位的那个数所需的位数相同（之前已经计算过）
            // 奇数比最近的那个偶数的1的个数多1
            result[i] = result[i >> 1] + i % 2;
        }
        return result;
    }
}
