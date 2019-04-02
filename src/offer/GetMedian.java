package offer;

/**
 * 面试题43
 */
public class GetMedian {
    public static void main(String[] args){
        System.out.println(numberOf1Between1AndN(21345));
    }

    private static int numberOf1Between1AndN(int n) {
        return core(String.valueOf(n));
    }

    private static int core(String s){
        if(s.length() == 1 && s.equals("0")) return 0;
        if(s.length() == 1 ) return 1;

        int first = s.charAt(0) - '0';
        int numFirst = 0; //最高位的出现次数
        if(first > 1)
            numFirst = (int)Math.pow(10, s.length() - 1); //在最高位一定会出现
        else if(first == 1)
            numFirst = Integer.valueOf(s.substring(1)) + 1; //最高位也会出现，但是次数没有上面那个多

        //其他低位上，选取一个为1，其他的排列组合
        int numOther = first * (s.length() - 1) * (int)Math.pow(10, s.length() - 2);

        //递归计算低位上的1的个数
        return numFirst + numOther + core(s.substring(1));
    }
}
