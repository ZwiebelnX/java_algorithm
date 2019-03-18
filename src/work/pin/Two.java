package work.pin;

import java.util.Scanner;

//85%
public class Two {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] alpha = new int[26];
        s = s.toLowerCase();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i < s.length(); i++){
            if(alpha[s.charAt(i) - 'a'] == 2){
                if(i + 1 < s.length() && s.charAt(i) >= s.charAt(i + 1)){
                    start = i + 1;
                    alpha[s.charAt(i) - 'a']--;
                }
            }
            else{
                break;
            }
        }

        System.out.println(s.charAt(start));
    }
}
