package leetcode.dp;

/**
 * questionIndex: 121
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] min = new int[prices.length];
        int[] opt = new int[prices.length];
        opt[0] = 0;
        min[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            min[i] = Math.min(min[i - 1], prices[i]);
            opt[i] = Math.max(opt[i - 1], prices[i] - min[i - 1]);
        }
        return opt[opt.length - 1];
    }
}
