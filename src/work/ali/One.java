package work.ali;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Sicong
 */

public class One {


    //假设pattern的简单字符个数和str中的字符个数是相同的
    public static void main(String[] args){
        String pattern1 = "abba";
        String str1 = "杭州 北京 北京 杭州";
        System.out.println(isPatternString(pattern1, str1));

        String pattern2 = "abcdabcd";
        String str2 = "北京 上海 广州 深圳 北京 上海 广州 深圳";
        System.out.println(isPatternString(pattern2, str2));
    }

    private static boolean isPatternString(String pattern, String s){
        Map<Character, String> stringMapping = new HashMap<>();
        String[] str = s.split(" ");
        for(int i = 0; i < pattern.length(); i++){
            if(!stringMapping.containsKey(pattern.charAt(i))){
                stringMapping.put(pattern.charAt(i), str[i]);
            }
            else if(!stringMapping.get(pattern.charAt(i)).equals(str[i])){
                return false;
            }
        }
        return true;
    }
}
