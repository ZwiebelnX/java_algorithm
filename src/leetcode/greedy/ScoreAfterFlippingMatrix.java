package leetcode.greedy;

/**
 * questionIndex: 861
 * 时间有点长，别人的7ms代码在下面，有空去理解一下
 */
public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(A));
    }

    private static int matrixScore(int[][] A) {
        int result = 0;
        int[] one = new int[A[0].length];
        for (int[] ints : A) {
            boolean flip = ints[0] == 0;
            for (int i = 0; i < ints.length; i++) {
                if (flip) {
                    ints[i] = ints[i] == 0 ? 1 : 0;
                }
                if (ints[i] == 1) {
                    one[i]++;
                }
            }
        }
        for (int i = 0; i < one.length; i++) {
            if (one[i] <= A.length / 2) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = A[j][i] == 0 ? 1 : 0;
                }

            }
        }
        for (int[] ints : A) {
            int temp = 0;
            for (int anInt : ints) {
                temp = temp << 1;
                temp += anInt;
            }
            System.out.println(temp);
            result += temp;
        }
        return result;
    }

    //神仙算法：
//    public int matrixScore(int[][] A) {
//        int R = A.length, C = A[0].length;
//        int ans = 0;
//        for (int c = 0; c < C; ++c) {
//            int col = 0;
//            for (int r = 0; r < R; ++r)
//                col += A[r][c] ^ A[r][0];
//            ans += Math.max(col, R - col) * (1 << (C-1-c));
//        }
//        return ans;
//    }
}
