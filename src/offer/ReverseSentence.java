package offer;

/**
 * 面试题58
 * 注意解决输入" "的问题
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I am a student."));
        System.out.println(reverseSentenceInChar("I am a student."));
    }

    private static String reverseSentence(String s) {
        String[] unit = s.split(" ");
        if (unit.length == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();

        for (int i = unit.length - 1; i >= 0; i--) {
            result.append(unit[i]);

            if (i != 0) result.append(" ");
        }

        return result.toString();
    }

    //练习通过直接操作char数组进行翻转
    private static void reverse(char[] chars, int begin, int end) {
        if (chars.length == 0) return;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = temp;
        }
    }

    private static String reverseSentenceInChar(String s) {
        if (s.length() == 0) return s;

        char[] chars = s.toCharArray();

        reverse(chars, 0, s.length() - 1);

        int begin = 0, end = 0;
        while (begin < s.length()) {
            if (chars[begin] == ' ') {
                begin++;
                end++;
            } else if (end >= s.length() || chars[end] == ' ') {
                reverse(chars, begin, --end);
                begin = ++end;
            } else end++;
        }
        return String.valueOf(chars);
    }
}
