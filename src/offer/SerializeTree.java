package offer;

import java.util.ArrayList;

public class SerializeTree {
    public static void main(String[] args){

    }

    private static ArrayList<String> Serialize(TreeNode root){
        ArrayList<String> result = new ArrayList<>();
        if(root == null){
            result.add("$");
            return result;
        }
        return null;
    }
}
