package offer;

/**
 * 面试题49
 */
public class UglyNumber {
    public static void main(String[] args){

    }

    private static int getUglyNumber(int index){
        if(index <= 0) return 0;

        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int T2 = 0, T3 = 0, T5 = 0;

        for(int i = 1; i < index; i++){
            int min = Math.min(Math.min(uglyArray[T2] * 2, uglyArray[T3] * 3), uglyArray[T5] * 5);
            uglyArray[i] = min;
            while(uglyArray[T2] * 2 <= min) T2++;
            while(uglyArray[T3] * 3 <= min) T3++;
            while(uglyArray[T5] * 5 <= min) T5++;
        }

        return uglyArray[index - 1];
    }
}
