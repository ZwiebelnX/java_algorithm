package work.tencent.qiu;


/**
 * <p>Title: IsBalanceTree</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Chen Sicong
 * @version V1.0
 */
public class IsBalanceTree{
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        TreeNode one = new TreeNode();
        TreeNode two = new TreeNode();
        TreeNode three = new TreeNode();
        TreeNode four = new TreeNode();

        root.left = one;
        root.right = two;
        two.left = three;
        three.left = four;

        System.out.println(isBalanced(root));
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

    private static int treeDepth(TreeNode root){
        if(root == null) return 0;
        return (Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1));
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;
}
