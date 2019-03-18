package work.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        String[] result = new String[cases];
        for(int i = 0; i < cases; i++){
            String s = in.next();
            s = doPattern(s);
            s = doPattern(s);

            result[i] = s;
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String doPattern(String s){
        if(s.length() <= 2){
            return s;
        }
        else {
            List<Integer> del = new ArrayList<>();
            for (int j = 2; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1) && s.charAt(j) == s.charAt(j - 2)) {
                    del.add(j);
                }
                if (j >= 3) {
                    if (s.charAt(j - 3) == s.charAt(j - 2) && s.charAt(j - 1) == s.charAt(j)) {
                        if (!del.contains(j - 2)) {
                            del.add(j);
                        }
                    }
                }

            }
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (del.contains(j)) continue;
                str.append(s.charAt(j));
            }
            return str.toString();
        }
    }
}
