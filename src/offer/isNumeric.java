package offer;

public class isNumeric {
    public static void main(String[] args){

    }

    private static boolean isNumeric(char[] str){
        String s = String.valueOf(str);
        return s.matches("[+-]?\\d*([.]?\\d+)?([eE][+-]?\\d+?)?");
    }
}
