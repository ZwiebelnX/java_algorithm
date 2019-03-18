package leetcode.greedy;


/**
 * QuestionIndex：122
 * 这题贪心在哪里呢？
 * 如果一直去寻找最近的两个差值最大的日期
 * 将他们加起来就是利润最大的情况
 * 也就是说多买多卖 每次都在短期的“山谷”和“山峰”买入和卖出
 * 估计炒短期股就是这么个原理吧
 */
public class BestTimeToByAndSellStockII {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int x = 0; x < prices.length; x++){
            if(x + 1 < prices.length && prices[x] <= prices[x + 1]){
                maxProfit += prices[x + 1] - prices[x];
            }
        }
        return maxProfit;
    }
}
