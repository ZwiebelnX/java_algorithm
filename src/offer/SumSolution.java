package offer;

/**
 * 面试题64
 */
public class SumSolution {
    public static void main(String[] args) {

    }

    private static int Sum_Solution(int n) {
        int sum = n;
        // 利用&&的短路特性终止递归
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
