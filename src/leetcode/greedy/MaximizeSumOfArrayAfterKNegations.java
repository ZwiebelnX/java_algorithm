package leetcode.greedy;


import java.util.Arrays;

/**
 * questionIndex: 1005
 * 提交了很多次才AC
 * 注意思考情形啊！！
 */
public class MaximizeSumOfArrayAfterKNegations {

    public static void main(String[] args){
        int[] A = {4, 2, 3};
        int K = 1;
        System.out.println(largestSumAfterKNegations(A, K));
    }

    private static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        boolean isPos = false;
        for(int i = 0; i < A.length && K > 0; K--){
            if(A[i] < 0 && !isPos){
                A[i] = -A[i];
                i++;
            }
            else if(A[i] > 0 || isPos){
                isPos = true;
                if(i >= 1){
                    i = A[i] > A[i - 1] ? i - 1 : i;
                }
                A[i] = -A[i];
            }
        }
        int result = 0;
        for (int i : A) {
            result += i;
        }
        return result;
    }
}
