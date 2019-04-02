package offer;

/**
 * 面试题42
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args){
        int[] a = {6,-3,-2,7,-15,1,2,2};
        findGreatestSumOfSubArray(a);
    }

    private static int findGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int[] opt = new int[array.length];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(i == 0) opt[i] = array[i];
            else{
                opt[i] = Math.max(opt[i - 1] + array[i], array[i]);
                max = Math.max(opt[i], max);
            }
        }
        return max;
    }
}
