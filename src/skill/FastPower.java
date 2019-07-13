package skill;

/**
 * <p>Title: FastPower</p>
 * <p>Description: 快速幂的java实现</p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 * @date 2019/7/13 20:49
 */
public class FastPower {
    public static void main(String[] args){
        System.out.println(fastPower(2, 10));
    }

    /*
    将指数转换成二进制，通过计算机擅长的移位操作进行快速幂运算
    例如：   a ^ 11 = a(2 ^ 0 + 2 ^ 1 + 2 ^ 3) = a ^ (1011)
     */

    private static int fastPower(int base, int pow){
        int result = 1; // 最终结果
        int temp = base; // 用于存储乘数的临时变量
        while (pow != 0){
            if((pow & 1) != 0){ // 当最后一位不为0时，乘以当前乘数
                result = result * temp;
            }

            temp = temp * temp; // 翻倍（权值增加）
            pow >>= 1; // 移位，对指数进行判断
        }
        return result;
    }
}
