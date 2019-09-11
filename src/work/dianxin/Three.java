package work.dianxin;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arrString = in.nextLine();
        arrString = arrString.substring(1, arrString.length() - 1);
        if (arrString.length() == 0) {
            System.out.println(0);
        } else {
            String[] arrStrings = arrString.split(", ");
            int[] arr = new int[arrStrings.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(arrStrings[i]);
            }
            System.out.println(maxSub(arr));
        }
    }

    private static int maxSub(int[] arr) {
        int[] p = new int[arr.length];
        Arrays.fill(p, -100000);
        p[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            p[i] = Math.max((p[i - 1] + current), current);
            max = Math.max(p[i], max);
        }
        return max;
    }
}
