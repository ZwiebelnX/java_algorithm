package work.tencent.offical;

import java.util.Scanner;

public class Three {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(core(n, k, 1, 1));
    }

    private static int core(int n, int k, int form, int num){
        if(num > n) return 0;
        if(form >= 2 * n) return 1;

        int result = 0;

        for(int i = form + 1; i <= form + k; i++){
            result += core(n, k, form + k, num + 1);
        }
        return result;
    }
}
