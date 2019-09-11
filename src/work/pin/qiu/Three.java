package work.pin.qiu;

import java.util.Scanner;

/**
 * <p>Title: Three</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Three {
    private static int total = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        count(1, n,1, 0, s);
        System.out.println(total);
    }

    public static void count(int countN, int n, int start, int currentSum, int goal) {
        if (start + currentSum > goal || countN > n) {
            return;
        }
        for (int i = start; i + currentSum <= goal ; i++) {
            if (i + currentSum == goal && countN == n) {
                total++;
                return;
            }
            if (i + currentSum < goal && countN < n) {
                count(countN + 1, n, i + 1, currentSum + i, goal);
            }
        }

    }

}
