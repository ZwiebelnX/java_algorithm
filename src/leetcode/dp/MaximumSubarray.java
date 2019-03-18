package leetcode.dp;

import java.util.Arrays;

/**
 * questionIndex: 53
 */
public class MaximumSubarray {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            opt[i] = Math.max(opt[i - 1] + nums[i], nums[i]);
        }

        Arrays.sort(opt);
        return opt[opt.length - 1];
    }
}
