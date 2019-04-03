package offer;

import static offer.TreeDepth.treeDepth;

/**
 * 面试题55题目2
 */
public class IsBalancedTree {
    public static void main(String[] args){

    }

    private static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if(Math.abs(left - right) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
