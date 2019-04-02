package offer;

import java.util.Arrays;

/**
 * 面试题45
 */
public class PrintMinNumber {
    public static void main(String[] args){
        System.out.println(printMinNumber(new int[]{3,32,321}));
    }

    private static String printMinNumber(int [] numbers) {
        Arrays.sort(numbers); //排序是关键，如果不排序结果可能是错的
        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            String str1 = number + result.toString();
            String str2 = result.toString() + number;
            result.delete(0, result.length());
            if (str1.compareTo(str2) > 0) { //解决大数问题
                result.append(str2);
            } else result.append(str1);
        }

        return result.toString();

    }
}
