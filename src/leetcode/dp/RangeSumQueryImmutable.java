package leetcode.dp;

/**
 * questionIndex: 303
 */
public class RangeSumQueryImmutable {
    private int[] sum;
    public RangeSumQueryImmutable(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sum[j];
        }
        else{
            return sum[j] - sum[i - 1];
        }
    }

    public static void main(String[] args){
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}
