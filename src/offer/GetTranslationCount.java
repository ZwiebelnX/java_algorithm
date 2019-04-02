package offer;

/**
 * 面试题46
 */
public class GetTranslationCount {
    public static void main(String[] args) {
        System.out.println(getTranslationCount(12258));
    }

    private static int getTranslationCount(int number) {
        if (number <= 0) return 0; //边界
        String s = String.valueOf(number);
        return core(s);
    }

    private static int core(String s) {
        int[] counts = new int[s.length()]; //用做翻译数的存储，每经过一个数字则更新
        int count;

        for (int i = s.length() - 1; i >= 0; i--) { //从后往前递推，减少重复子任务的计算
            if (i < s.length() - 1) count = counts[i + 1]; //初始化当前翻译数
            else count = 1;
            if (i < s.length() - 1) {
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) { //判断前后两个数字组合是否有效
                    if (i < s.length() - 2) count += counts[i + 2]; //有效则将当前翻译数及组合后的翻译数相加，
                        // 即加上counts[i + 2]
                    else count += 1;
                }
            }
            counts[i] = count;
        }

        return counts[0];
    }
}
