package work.dianxin;

import java.util.Scanner;

/**
 * <p>Title: Two</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        StringBuilder result = new StringBuilder();
        int[] number = new int[]{1000, 500, 100, 50, 10, 5, 1};
        String[] symbol = new String[]{"M", "D", "C", "L", "X", "V", "I"};
        for (int i = 0; i < number.length; i++) {
            int count = num / number[i];
            if (number[i] == 1 && num == 4) {
                result.append("IV");
                num -= 4;
            } else {
                for (int j = 0; j < count; j++) {

                    result.append(symbol[i]);
                }
                num -= count * number[i];
            }

        }
        System.out.println(result.toString());
    }
}
