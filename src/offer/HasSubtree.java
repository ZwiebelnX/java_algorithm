package offer;

/**
 * 面试题26
 * 注意思路
 * 1、遍历公树，找到和子树根相同的节点
 * 2、比较下面的结构是否和子树相同
 */
public class HasSubtree {
	public static void main(String[] args) {
		
	}
	
	private static boolean hasSubTree(TreeNode root1,TreeNode root2) {
		
        boolean result = false;
        
        if(root1 != null && root2 != null) {
        	if(root1.val == root2.val) result = hasSubTreeCore(root1, root2); //结点值是否和子树的根相同
            //不相同则向下遍历（NLR）
        	if(!result) result = hasSubTree(root1.left, root2);
        	if(!result) result = hasSubTree(root1.right, root2);
        }
        
        return result;
    }
	
	private static boolean hasSubTreeCore(TreeNode root1, TreeNode root2) {
		if(root2 == null) return true; //子树已经遍历完成，代表存在子结构
		
		if(root1 == null || root1.val != root2.val) return false; //结点值不相等

        //子树未遍历完成，向下遍历
		return hasSubTreeCore(root1.left, root2.left) && hasSubTreeCore(root1.right, root2.right);
	}
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
