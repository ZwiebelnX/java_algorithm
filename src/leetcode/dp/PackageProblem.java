package leetcode.dp;

public class PackageProblem {
    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        System.out.println(dpPackage(weight, value, 10));
    }

    public static int dpPackage(int[] weight, int[] value, int empty) {
        int[][] opt = new int[weight.length][empty + 1];
        for (int i = 0; i < empty + 1; i++) {
            if (weight[0] <= i) {
                opt[0][i] = value[0];
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= empty; j++) {
                if (weight[i] > j) {
                    opt[i][j] = opt[i - 1][j];
                } else {
                    opt[i][j] = Math.max(opt[i - 1][j], opt[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return opt[opt.length - 1][opt[0].length - 1];
    }
}
