package offer;

/**
 * 面试题15
 */
public class NumberOfOne {
    public static void main(String[] args){

    }

    private static int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
