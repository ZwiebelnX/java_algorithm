package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * questionIndex: 657
 */
public class RobotReturnToOrigin {
    public static void main(String[] args){

    }

    private boolean judgeCircle(String moves) {
        Map<Character, Integer> ans = new HashMap<>(4);

        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            ans.merge(c, 1, (value, val) -> val += value);
        }

        return ans.getOrDefault('U', 0).equals(ans.getOrDefault('D', 0)) &&
                ans.getOrDefault('R', 0).equals(ans.getOrDefault('L', 0));
    }
}
