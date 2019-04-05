package offer;

/**
 * 面试题66
 */
public class MultiplyMatrix {
    public static void main(String[] args){

    }

    private static int[] multiply(int[] A) {
        int length = A.length;

        int[] B = new int[length];
        if(length != 0){
            B[0] = 1;

            //计算下三角，注意下标不是对应的
            for(int i = 1; i < length; i++){
                B[i] = B[i - 1] * A[i - 1];
            }

            //计算上三角，并且计算最终结果。注意下标也不是对应的
            int temp = 1;
            for(int i = length - 2; i >=0; i--){
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;

    }
}
