package work.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            result.add(total(end) - total(start - 1));
            //System.out.println(total(end ) - total(start - 1));
        }
        result.forEach(System.out::println);
    }

    private static int total(int n) {
        if (n % 2 == 0) {
            return (n + 1) / 2;
        } else {
            return -(n + 1) / 2;
        }
    }
}
