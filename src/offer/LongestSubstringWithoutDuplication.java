package offer;

/**
 * 面试题48
 * 动态规划
 */
public class LongestSubstringWithoutDuplication {
    public static void main(String[] args){
        String s = "arabcacfr";
        System.out.println(solution(s));
    }

    private static int solution(String s){
        if(s.length() == 0) return 0;
        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26]; //初始化每个字母上一次的出现位置为-1

        for(int i = 0; i < 26; i++){
            position[i] = -1;
        }

        for(int i = 0; i < s.length(); i++){
            int pervIndex = position[s.charAt(i) - 'a']; //获取当前字符上次出现的位置
            //如果不在当前序列内
            if(pervIndex < 0 || i - pervIndex > curLength)
                curLength++;
            //否则的话，当前为为无重复字串之一
            else{
                if(curLength > maxLength)
                    maxLength = curLength; //更新最长数组
                curLength = i - pervIndex; //减去前面产生重复的字串
            }
            position[s.charAt(i) - 'a'] = i;
        }

        if(curLength > maxLength) maxLength = curLength;
        return maxLength;
    }
}
