package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * questionIndex: 804
 */
public class UniqueMorseCodeWords {
    public static void main(String[] args){

    }

    private static int uniqueMorseRepresentations(String[] words) {
        if(words.length == 0) return 0;
        String[] morse  = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> ans = new HashSet<>();

        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                temp.append(morse[word.charAt(i) - 'a']);
            }
            ans.add(temp.toString());
        }
        return ans.size();
    }
}
