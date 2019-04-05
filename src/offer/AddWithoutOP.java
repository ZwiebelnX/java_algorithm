package offer;

public class AddWithoutOP {
    public static void main(String[] args){
        System.out.println(add(5, 17));
    }

    private static int add(int num1, int num2){
        int sum, carry;

        do {
            //异或计算不算进位的结果
            sum = num1 ^ num2;
            //计算进位结果
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
            //不断计算直至没有产生进位
        } while (num2 != 0);

        return num1;
    }
}
