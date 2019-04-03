package offer;

/**
 * 面试题56
 */
public class FindNumsAppearOnce {
    public static void main(String[] args){

    }

    private static void findNumsAppearOnce(int[] array, int[] num1, int[] num2){
        if(array.length < 2) return;
        int resultOR = 0;
        for (int i2 : array) {
            resultOR ^= i2;
        }

        int indexOf1 = findFirstBitIs1(resultOR);

        for (int i1 : array) {
            if (isBit1(i1, indexOf1)) num1[0] ^= i1;
            else num2[0] ^= i1;
        }
    }

    private static int findFirstBitIs1(int num){
        int index = 0;
        while (((num & 1) == 0) && (index < 8 * Integer.SIZE)){
            num = num >> 1;
            index++;
        }
        return index;
    }

    private static boolean isBit1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }
}
