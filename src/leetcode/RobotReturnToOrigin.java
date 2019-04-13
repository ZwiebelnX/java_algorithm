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
        int[] temp = new int[2];

        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            switch (c){
                case 'U':
                    temp[0]++;
                    break;
                case 'D':
                    temp[0]--;
                    break;
                case 'L':
                    temp[1]++;
                    break;
                case 'R':
                    temp[1]--;
                    break;
            }
        }

        return temp[0] == 0 && temp[1] == 0;
    }
}
