package offer;

/**
 * 面试题19
 */
public class MatchPattern {
    public static void main(String[] args) {

    }

    // 边界处理有问题
//    private static boolean match(char[] str, char[] pattern) {
//        return matchCore(str, pattern, 0, 0);
//    }
//
//    private static boolean matchCore(char[] str, char[] pattern, int pStr, int pPattern){
//
//        //当后一个字符是*时处理较复杂
//        if(pattern[pPattern + 1] == '*'){
//            if(pattern[pPattern] == str[pStr] || pattern[pPattern] == '.'){ // 注意*和.可以连续出现，结合自动机分析
//                return matchCore(str, pattern, pStr + 1, pPattern + 2)      // 移动到下一个状态
//                        || matchCore(str, pattern, pStr + 1, pPattern)              // 保持当前状态
//                        || matchCore(str, pattern, pStr, pPattern + 2);         // 匹配0个字符（跳至下一个状态）
//            }
//            else{
//                return matchCore(str, pattern, pStr, pPattern + 2);     // 匹配0个字符
//            }
//        }
//
//        if(str[pStr] == pattern[pPattern] || pattern[pPattern] == '.'){
//            return matchCore(str, pattern, pStr + 1, pPattern + 1);
//        }
//
//        return false;
//    }

    public boolean match(char[] str, char[] pattern) {
        return matchTwo(str, 0, str.length, pattern, 0, pattern.length);
    }

    private boolean matchTwo(char[] str, int i, int length1, char[] pattern,
                             int j, int length2) {
        if (i == length1 && j == length2) {
            return true;
        }
        if (i == length1) {
            while (j != length2) {
                if (pattern[j] != '*' && (j + 1 >= length2 || pattern[j + 1] != '*')) {
                    return false;
                }
                j++;
            }
            return true;
        }
        if (j == length2) {
            return false;
        }
        if (j + 1 == length2) {
            if (str[i] == pattern[j] || pattern[j] == '.')
                return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
            else {
                return false;
            }
        }
        if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] != '*')
            return matchTwo(str, i + 1, length1, pattern, j + 1, length2);
        if ((str[i] == pattern[j] || pattern[j] == '.') && pattern[j + 1] == '*')
            return matchTwo(str, i, length1, pattern, j + 2, length2) || matchTwo(str, i + 1, length1, pattern, j, length2);
        if (pattern[j + 1] == '*')
            return matchTwo(str, i, length1, pattern, j + 2, length2);
        return false;
    }
}
