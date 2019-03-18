package leetcode.greedy;

import java.util.Arrays;

/**
 * QuestionIndex: 455
 */
public class AssignCookies {
    public static void main(String[] args){

    }

    private int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
