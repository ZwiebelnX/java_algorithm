package work.jingdong;

import java.util.Scanner;

public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        int m = in.nextInt();
        String[] pattern = new String[m];
        for(int i = 0; i < m; i++){
            pattern[i] = in.nextLine();
        }

        char[] str = in.next().toCharArray();

        int[] opt = new int[str.length];

        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < pattern.length; j++){
                if(pattern.length <= j + 1){
                    int k = 0;
                    for(; k < pattern[j].length(); k++){
                        if(pattern[j].charAt(k) != i - pattern.length + k) break;
                    }
                    if(k == pattern[j].length() - 1){
                        if(i == 0) opt[0] = 1;
                    }
                }
            }
        }
    }
}
