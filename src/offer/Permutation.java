package offer;

import java.util.ArrayList;

/**
 * 面试题38
 */

public class Permutation {
    public static void main(String[] args){
        Permutation p = new Permutation();
        String s = "abc";
        ArrayList<String> result = p.permutation(s);
        System.exit(0);

    }

    private ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.equals("")) return result;

        permutationCore(str, 0, result);
        return result;
    }

    private void permutationCore(String str, int index, ArrayList<String> result){
        if(index < str.length()){
            for(int i = index; i < str.length(); i++){
                StringBuilder string = new StringBuilder();
                for(int j = 0; j < str.length(); j++){
                    if(j == i) string.append(str.charAt(index));
                    else if(j == index) string.append(str.charAt(i));
                    else string.append(str.charAt(j));
                }

                 permutationCore(string.toString(), index + 1, result);
            }
        }
        else{
            if(!result.contains(str)){
                result.add(str);
            }
        }
    }
}
