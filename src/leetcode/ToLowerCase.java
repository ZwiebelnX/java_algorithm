package leetcode;

/**
 * questionIndex:709
 */
public class ToLowerCase {
    public static void main(String[] args){
        String str = "hello LOVELY";
        System.out.println(toLowerCase(str));
    }

    private static String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] -= ('A' - 'a');
            }
        }

        return String.valueOf(chars);
    }
}
