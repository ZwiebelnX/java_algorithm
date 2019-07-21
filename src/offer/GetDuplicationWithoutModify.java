package offer;

/**
 * <p>Title: GetDuplicationWithoutModify</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Chen Sicong
 * @version V1.0
 */

public class GetDuplicationWithoutModify {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 5, 4, 3, 1, 6, 7};
        System.out.println(getDuplication(numbers));
    }

    private static int getDuplication(int[] numbers){
        if(numbers.length == 0) return -1;

        int start = 1;
        int end = numbers.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start; //移位代替 /2 效率更高
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if(count > 1)
                    return start;
                else break;
            }
            if(count > (middle - start + 1)){
                end = middle;
            }
            else start = middle + 1;
        }

        return -1;
    }

    /*
    计算子数组中有多少个数字
     */
    private static int countRange(int[] numbers, int start, int end) {
        if(numbers.length == 0) return 0;

        int count = 0;
        for (int number : numbers) {
            if (number >= start && number <= end) ++count;
        }
        return count;
    }
}
