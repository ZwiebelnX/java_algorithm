package work.webank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int cases = in.nextInt();


        for(int i = 0; i < cases; i++){
            int start = in.nextInt();
            int count = 0;
            int current = 1;
            while (current != start){
                if(count > 20){
                    result.append(-1).append(" ");
                    break;
                }
                if(current > start){
                    if((current - 1) % 3 == 0 && (current - 1) / 3 != 1) current = (current - 1) / 3;
                    else current *= 2;
                }
                else{
                    current *= 2;
                }
                count++;
            }
            if(count <= 20) result.append(count).append(" ");
        }

        System.out.println(result.toString());
    }
}
