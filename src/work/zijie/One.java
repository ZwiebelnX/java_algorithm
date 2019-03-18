package work.zijie;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] coins = {64, 16, 4, 1};
        int charge = 1024 - in.nextInt();
        int result = 0;

        for (int coin : coins) {
            result += charge / coin;
            charge %= coin;
        }

        System.out.println(result);

    }
}
