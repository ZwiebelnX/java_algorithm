package work.pin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Three {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int banks = in.nextInt();
        int distance = in.nextInt();
        int total = 0;
        int firstCash = 0;
        int firstPos = -1;
        int secCash = 0;
        int secPos = -1;
        int[] X = new int[100000001];
        for(int i = 0; i < banks; i++){
            int currentPos = in.nextInt();
            int currentCash = in.nextInt();
            if(currentCash > firstCash){
                secCash = firstCash;
                firstCash = currentCash;
                firstPos = currentPos;
            }
            else{
                if(currentCash > secCash && (currentPos - firstPos) >= distance) secCash = currentCash;
            }
        }
        System.out.println(firstCash + secCash);
    }
}
