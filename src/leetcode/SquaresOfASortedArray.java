package leetcode;

/**
 * questionIndex: 977
 */
public class SquaresOfASortedArray {
    public static void main(String[] args){

    }

    private static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        int left = 0, right = A.length - 1;
        int p = result.length - 1;

        while (left <= right && p >= 0){
            int powLeft = A[left] * A[left];
            int powRight = A[right] * A[right];

            result[p--] = Math.max(powLeft, powRight);
            if(powLeft > powRight) left++;
            else right--;
        }
        return result;
    }
}
