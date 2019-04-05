package offer;

public class LeftRotateString {
    public static void main(String[] args){
        String str = "abcXYZdef";
        System.out.println(leftRotateString(str, 3));
    }

    private static String leftRotateString(String str,int n) {
        if(str.length() == 0 || n <= 0) return str;

        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i = n; i < str.length(); i++){
            result.append(chars[i]);
        }

        for(int i = 0; i < n; i++){
            result.append(chars[i]);
        }

        return result.toString();
    }
}
