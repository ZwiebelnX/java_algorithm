package leetcode.greedy;

/**
 * questionIndex: 984
 * 注意 拿到题先不要做 先把问题往下分解成原子问题
 * 中文LeetCode测试用例有问题
 */
public class StringWithoutAAAorBBB {
    private static String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) { //原子问题1：当前面两个字符相同，不应该写入第三个相同的字符
                if (ans.charAt(L-1) == 'b') //原子问题2：前面两个字符已经相同了，是写入a还是写入b
                    writeA = true;
            } else {
                if (A >= B) //原子问题3：当前面两个字符不一样时：贪心算法：先把多的符号给写进去
                    //其实在这里有个好处就是，当到后面两个字符数目差不多相等时，会把a和b交替写入
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args){
        System.out.println(strWithout3a3b(2, 5));
    }
}
