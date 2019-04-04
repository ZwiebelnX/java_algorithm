package offer;

/**
 * 面试题60
 */
public class PrintProbability {
    private static int maxValue = 6;

    public static void main(String[] args) {
        printProbability(4);
    }

    private static void printProbability(int number) {
        if (number < 1) return;

        // 设置两个数组存储和为n出现的次数
        int[][] probabilities = new int[2][maxValue * number + 1];
        int flag = 0;

        // 初始化前maxValue个的出现次数为1。在number之前的数在最后不会被打印出来
        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }

        // 加入后面的骰子
        for (int i = 2; i <= number; i++) {
            //清空不可能出现的和的位置（其实可以不做，只要最后不打印出来即可）
            for (int j = 0; j < i; j++) {
                probabilities[1 - flag][j] = 0;
            }

            for (int j = i; j <= maxValue * i; j++) {
                probabilities[1 - flag][j] = 0;
                // 此时和为n的骰子出现的次数应该等于上一轮循环中骰子点数和位n-1 ~ n-6的次数的总和
                // 因为当前骰子也可以掷出1 - 6 的数
                for (int k = 1; k <= j && k <= maxValue; k++) {
                    probabilities[1 - flag][j] += probabilities[flag][j - k];
                }
            }
            //交替数组
            flag = 1 - flag;
        }

        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%d : %e \n", i, ratio);
        }
    }
}
