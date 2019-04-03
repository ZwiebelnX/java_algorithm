package offer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public static void main(String[] args){

    }

    private static int firstNotRepeatingChar(String str){
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            else{
                map.put(c, -2);
            }
        }

        for(int i = 0; i < str.length(); i++){
            int index = map.get(str.charAt(i));
            if(index >= 0) return i;
        }

        return -1;
    }
}
