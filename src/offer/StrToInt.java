package offer;

/**
 * 没有考虑int溢出
 */
public class StrToInt {
    public static void main(String[] args){
        System.out.println(strToInt("123456"));
    }

    private static int strToInt(String str) {
        char[] chars = str.toCharArray();
        if(chars.length == 0) return 0;

        int sign = -1;
        if(chars[0] == '-') sign = 1;

        int sum = 0;
        int i = (chars[0] == '+' || sign == 1 ? 1 : 0);
        for(; i < chars.length; i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                sum = sum * 10 + (chars[i] - '0');
            }
            else{
                return 0;
            }
        }
        return sum * sign * -1;
    }
}
