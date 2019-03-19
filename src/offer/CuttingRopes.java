package offer;

/**
 * 面试题14
 */
public class CuttingRopes {
    public static void main(String[] args){

    }

    private static int maxProductAfterCutting(int length){
        if(length < 2) return 0;

        if(length == 2) return 1;
        if(length == 3) return 2;


        int[] opt = new int[length + 1];
        opt[0] = 0; // 不使用
        opt[1] = 0;
        opt[2] = 2; // 对于2和3，不剪比剪大，这个不符合子问题的一致性。故单独列出
        opt[3] = 3;
        for(int i = 4; i <= length; i++){
            int max = -1;
            for(int j = 0; j < i / 2; j++){
                int len = opt[j] * opt[i - j]; //每次剪成段，每一段的最优解相乘一定是这一次的最优解
                if(max < len) max = len;
            }
            opt[i] = max;
        }

        return opt[length];
    }
}
