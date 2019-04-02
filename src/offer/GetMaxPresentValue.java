package offer;

/**
 * 面试题47
 * 带权动态规划 + 滚动矩阵
 */
public class GetMaxPresentValue {
    public static void main(String[] args){
        int rows = 4;
        int cols = 4;
        int[] matrix = {1, 10, 3, 8, 12, 2, 9, 6, 5, 7, 4, 11, 3, 7, 16, 5};
        System.out.println(getValue(matrix, rows, cols));
    }

    private static int getValue(int[] matrix, int rows, int cols){
        if(matrix.length == 0 || rows <= 0 || cols <= 0) return 0;

        int[] opt = new int[cols];  //滚动矩阵，空间复杂度O(n)

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int left = 0;
                int up = 0;
                if(j - 1 >= 0) left = opt[j - 1];
                if(i - 1 >= 0) up = opt[j];
                //状态转移方程，到达当前这个方格的路径只能从上方或者左方走来
                opt[j] = Math.max(left, up) + matrix[cols * i + j];
            }
        }
        //右下角即为最佳答案
        return opt[opt.length - 1];
    }
}
