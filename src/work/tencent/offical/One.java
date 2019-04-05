package work.tencent.offical;

import java.util.Scanner;

public class One {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int total = in.nextInt();
        int[] cases = new int[total];
        int ml = in.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < total; i++){
            cases[i] = in.nextInt();
            if(cases[i] < min){
                min = cases[i];
            }
        }

        for(int i = 0; i < total; i++){
            if(cases[i] > min){
                ml -= cases[i] - min;
                if(ml < 0){
                    System.out.println(min);
                    return;
                }
                cases[i] = min;
            }
        }

        int totalMl = total * min;
        if(totalMl < ml){
            System.out.println(-1);
            return;
        }

        int result = min - min / total;
        if(totalMl % total != 0){
            System.out.println(result - 1);
        }
        else{
            System.out.println(result);
        }


    }
}
