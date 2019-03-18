package leetcode.dp;

/**
 * questionIndex: 198
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        //一定要注意临界状态啊啊啊啊啊！！！！！！！！！！！！！！！！！！！！！！！！
        //每次都漏！ @#$%……&
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            opt[i] = Math.max(opt[i - 2] + nums[i], opt[i - 1]);
        }

        return opt[opt.length - 1];
    }
}
