package work.wangyi;

import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();

        char[] str1 = input.split(",")[0].toCharArray();
        char[] str2 = input.split(",")[1].toCharArray();
        int[] diff = new int[str1.length];
        int result = 0;

        for(int i = 0; i < str1.length; i++){
            if(str1[i] == '3'){
                result++;
                str1[i] = '2';
            }
            diff[i] = str2[i] - str1[i];
        }

        for(int i = 0; i < str1.length; i++){
            if(diff[i] != 0){
                int curDiff = diff[i];
                for(int j = i + 1; j < str1.length; j++){
                    if(curDiff + diff[j] == 0){
                        result++;
                        diff[i] = 0;
                        diff[j] = 0;
                        curDiff = 0;
                        break;
                    }
                }
                if(curDiff != 0){
                    result += Math.abs(diff[i]);
                    diff[i] = 0;
                }
            }
        }
        System.out.println(result);
    }
}
