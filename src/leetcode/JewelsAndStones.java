package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * questionIndex：771
 */
public class JewelsAndStones {
    public static void main(String[] args){
        String J = "z";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    private static int numJewelsInStones(String J, String S) {
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();

        Set<Character> jSet = new HashSet<>();
        int result = 0;

        if(j.length == 0 || s.length == 0) return 0;

        for (char c : j) {
            jSet.add(c);
        }

        for (char c : s) {
            if(jSet.contains(c)) result++;
        }

        return result;
    }
}
