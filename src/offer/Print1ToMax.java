package offer;

import java.math.BigInteger;

/**
 * 面试题17
 */
public class Print1ToMax {
    public static void main(String[] args) {
        // solutionWithBigDigital(3);
        solutionWithChars(3);
    }

    // 大数解决
    private static void solutionWithBigDigital(int n) {
        if (n <= 0) return;

        BigInteger max = new BigInteger("9");
        BigInteger temp = new BigInteger("1");
        for (int i = 0; i < n - 1; i++) {
            temp = temp.multiply(BigInteger.valueOf(10));
            max = max.add(temp.multiply(BigInteger.valueOf(9)));
        }

        BigInteger result = new BigInteger("0");
        BigInteger add = new BigInteger("1");
        while (max.compareTo(result) < 0){ //compareTo: 小于、等于或大于：-1 0 1
            result = result.add(add);
            System.out.println(result.toString());
        }

    }

    // 字符串解决
    // 有两种方式，基于模拟加法的，基于递归的
    // 这里是基于递归的
    private static void solutionWithChars(int n){
        if(n <= 0) return;
        char[] numbers = new char[n];

        for(int i = 0; i < 10; i++){
            numbers[0] = (char)(i + '0'); //设置第一位的数字
            printRecursively(numbers, 0);
        }


    }

    private static void printRecursively(char[] numbers, int index){
        //出口：达到最后一位数
        if(index == numbers.length - 1){
            printNumber(numbers);
            return;
        }

        for(int i = 0; i < 10; i++){
            numbers[index + 1] = (char)(i + '0'); // 注意：这里是设置下一位的数字！
            printRecursively(numbers, index + 1);
        }
    }

    // 打印函数，剔除开头的0
    private static void printNumber(char[] numbers){
        boolean isZero = true;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != '0') isZero = false;
            if(!isZero){
                StringBuilder result = new StringBuilder();
                for(int j = i; j < numbers.length; j++){
                    result.append(numbers[j]);
                }
                System.out.println(result.toString());
                return;
            }
        }
    }
}
