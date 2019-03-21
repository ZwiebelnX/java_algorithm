package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * questionIndex: 844
 */
public class BackspaceStringCompare {
    public static void main(String[] args){
        String S = "";
        String T = "";
        System.out.println(backspaceCompare(S, T));
    }

    private static boolean backspaceCompare(String S, String T) {
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#'){
                stackS.poll();
            }
            else{
                stackS.offerFirst(S.charAt(i));
            }
        }

        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) == '#'){
                stackT.poll();
            }
            else{
                stackT.offerFirst(T.charAt(i));
            }
        }

        if(stackS.size() != stackT.size()) return false;

        for(int i = 0; i < stackS.size(); i++){
            if(stackS.poll() != stackT.poll()) return false;
        }

        return true;



    }
}
