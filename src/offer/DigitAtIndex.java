package offer;

public class DigitAtIndex {
    public static void main(String[] args){
        System.out.println(digitAtIndex(1001));
    }

    private static int digitAtIndex(int index){
        if(index < 0) return -1; //边界
        int digits = 1; //当前数字位数，初始化为一位
        while(true){
            int numbers = countOfIntegers(digits); //当前位数中存在的数字的个数（如1位为10，2位为90 * 2 = 180）
            if(index < numbers * digits) //如果位置处于当前范围内
                return digitAtIndex(index, digits);
            index -= digits * numbers; //否则继续计算
            digits++;
        }
    }

    private static int countOfIntegers(int n){ //计算n位的所有数中的单个数字的个数
        if(n == 1) return 10;

        int count = (int)Math.pow(10, n - 1);
        return 9 * count; //9 * 10 ^ 位数 - 1
    }

    private static int digitAtIndex(int index, int digits){ //计算在当前范围内目标的所在位置
        int number = index / digits; //第几个数字
        int i = index % digits; //第几位
        return String.valueOf(beginNumber(digits) + number).charAt(i) - '0';
    }

    //获取当前范围的开始数，如2位数为10，3位数为100
    private static int beginNumber(int digits){
        if(digits == 1) return 0;
        return (int)Math.pow(10, digits - 1);
    }
}
