package offer;

/**
 * 面试题54
 */
public class TreeDepth {
    public static void main(String[] args){

    }

    static int treeDepth(TreeNode root){
        if(root == null) return 0;
        return (Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1));
    }
}
