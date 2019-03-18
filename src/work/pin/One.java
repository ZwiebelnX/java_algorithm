package work.pin;

import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] a = new int[length], b = new int[length];
        int result = 0;
        for(int i = 0; i < length; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < length; i++){
            b[i] = in.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0; i < length; i++){
            result += a[i] * b[length - i - 1];
        }

        System.out.println(result);
    }
}
