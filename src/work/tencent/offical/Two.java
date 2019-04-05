package work.tencent.offical;

import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int total = in.nextInt();
        if(total < 0){
            System.out.println(0);
            return;
        }

        int[] point = new int[total];
        int[] money = new int[total];
        //int[] ratio = new int[total];

        for(int i = 0; i < total; i++){
            point[i] = in.nextInt();
        }

        for(int i = 0; i < total; i++){
            money[i] = in.nextInt();
            //ratio[i] = point[i] / money[i];
        }

        int myPoint = 0;
        int result = 0;
        for(int i = 0; i < total; i++){
            if(myPoint < point[i]){
                while (myPoint < point[i]){
                    int maxRatio = -1;
                    int index = i;
                    for(int j = 0; j <= i; j++){
                        int ratio = point[j] / money[j];
                        if(ratio > maxRatio && money[j] > 0){
                            maxRatio = ratio;
                            index = j;
                        }
                    }

                    myPoint += point[index];
                    result += money[index];
                    money[index] = -1;
                }
            }
        }

        System.out.println(result);
    }
}
