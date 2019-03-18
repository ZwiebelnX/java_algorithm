package offer;

public class ReplaceSpace {
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("HelloWorld ");
        System.out.println(replaceSpace(str));
    }
    private static String replaceSpace(StringBuffer str) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                result.append("%20");
            }
            else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
