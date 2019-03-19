package offer;

/**
 * 面试题16
 */
public class Power {
    public static void main(String[] args){
        System.out.println(power(2, -1));
    }

    private static double power(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        double sum = 1;

        // 注意两点：
        // double之间是否相等不能直接用==，因为存在精度丢失，得到的结果永远是false
        // 对0求倒数是不合法的，在这里单独提出出口
        if(Math.abs(base - 0) < 0.0001 && exponent < 0){
            return 0;
        }
        int pow = Math.abs(exponent);
        for(int i = 0 ; i < pow; i++){
            if(exponent > 0) sum *= base;
            else sum /= base;
        }
        return sum;
    }
}
