package work.dianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>Title: One</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        if(total == 0) System.exit(0);
        int[] array = new int[total];
        for (int i = 0; i < total; i++) {
            array[i] = in.nextInt();
        }
        Arrays.parallelSort(array);
        System.out.println(array[total / 2]);
    }
}
