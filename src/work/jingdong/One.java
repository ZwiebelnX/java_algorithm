package work.jingdong;

import java.util.Scanner;

public class One {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] count = new int[cases + 1];
        int[] connectToRoot = new int[cases + 1];
        int pConnect = 0;


        int total = 0;

        for(int i = 0; i < cases - 1; i++){
            int from = in.nextInt();
            int to = in.nextInt();

            count[to]++;

            if(to == 1){
                connectToRoot[pConnect] = from;
                pConnect++;
            }
        }

        int one = connectToRoot[0];
        int two = connectToRoot[1];
        pConnect = 2;
        int tempSum = 0;
        while (one > 0 || two > 0){
            count[one]--;
            count[two]--;
            tempSum++;
            if(count[one] <= 0) one = connectToRoot[pConnect++];
            if(count[two] <= 0) two = connectToRoot[pConnect++];
        }

        count[1] = (int)((double)(count[1] / 2) + 0.5);


        for(int i = 1; i < count.length; i++){
            if(count[i] >= 0)
                total += count[i];
        }
        total += tempSum;

        System.out.println(total);

    }


}
