package leetcode.dp;

public class MinCostClimbingStairs {

    public static void main(String[] args){
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int[] opt = new int[cost.length + 1];
        opt[0] = opt[1] = 0;
        for(int i = 2; i <= cost.length; i++){
            opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
        }
        return opt[opt.length - 1];
    }
}
