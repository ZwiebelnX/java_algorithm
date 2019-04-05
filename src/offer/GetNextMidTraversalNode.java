package offer;

/**
 * 面试题8
 */
public class GetNextMidTraversalNode {
    public static void main(String[] args) {

    }

    private static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;

        TreeLinkNode pNext = null;

        // 1: 如果当前节点有右子树
        if(pNode.right != null){
            pNext = pNode.right;
            while (pNext.left != null){
                pNext = pNext.left;
            }
        }

        // 如果当前节点没有右子树
        else if(pNode.next != null){
            TreeLinkNode pCurrent = pNode;
            pNext = pNode.next;
            // 2: 如果是父节点的左子树，那么下一个节点就是父节点
            // 3: 如果是父节点的右子树，那么向上查找。如果向上查找没有找到符合情况2的，那么当前节点是中序遍历中最后一个节点
            // 注意！这种情况下只有一个出口，情况2
            while(pNext != null && pCurrent == pNext.right){
                pCurrent = pNext;
                pNext = pNext.next;
            }
        }

        return pNext;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}