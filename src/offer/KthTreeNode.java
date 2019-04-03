package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题54
 * 中序遍历的栈实现
 */
public class KthTreeNode {
    public static void main(String[] args){

    }

    private static TreeNode kthTreeNode(TreeNode root, int k){
        if(root == null || k <= 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.offerFirst(node);
                node = node.left;
            }
            else{
                node = stack.poll();
                int value = node.val;
                k--;
                if(k <= 0) return node;
                else{
                    node = node.right;
                }
             }
        }

        return null;

    }
}
