package offer;


/**
 * 由NLR和LNR构造二叉树
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        ReConstructBinaryTree con = new ReConstructBinaryTree();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = con.reConstructBinaryTree(pre, in);

        //TODO 分层遍历
        System.exit(0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1); //从根节点开始循环调用
    }

    /**
     *
     * @param pre NLR
     * @param in LNR
     * @param preStart NLR数组中的开始索引
     * @param preEnd NLR数组中的结束索引
     * @param inStart LNR数组中的开始索引
     * @param inEnd LNR数组中的结束索引
     * @return 一个节点
     */
    private TreeNode buildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if(inStart < in.length && preStart < in.length){
            TreeNode node = new TreeNode(pre[preStart]); //NLR的第一个节点一定是根节点
            int nodeIndex = findNodeIndexInLNR(in, node.val); //查找当前节点在LNR中的位置
            int leftTreeLength = nodeIndex - inStart; //左子树在数组中的长度，用来构造左右子树
            if (leftTreeLength <= 0) { //如果不存在左子树，直接返回null
                node.left = null;
            } else {
                node.left = buildTree(pre, in, preStart + 1, preStart + leftTreeLength, //构造左子树的NLR和LNR
                        inStart, nodeIndex - 1);
            }

            if (nodeIndex >= inEnd ) {
                node.right = null;
            } else {
                node.right = buildTree(pre, in, preStart + leftTreeLength + 1, preEnd, //构造右子树的NLR和LNR
                        nodeIndex + 1, inEnd);
            }
            return node;
        }
        //边界条件 如果上一个元素是最后一个元素
        else{
            return null;
        }
    }

    private int findNodeIndexInLNR(int[] in, int find) {
        int result = -1;
        for(int i = 0; i < in.length; i++){
            if(in[i] == find){
                result = i;
            }
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
