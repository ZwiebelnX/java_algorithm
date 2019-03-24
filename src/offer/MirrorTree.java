package offer;



/**
 * 面试题28
 *
 */
public class MirrorTree {

    public static void main(String[] args){

    }

    private static void mirror(TreeNode root) {
        if(root != null){
            TreeNode flipTemp = root.left;
            root.left = root.right;
            root.right = flipTemp;

            mirror(root.left);
            mirror(root.right);
        }

    }

}
