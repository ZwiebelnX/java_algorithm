package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 面试题32
 */
public class PrintFromTopToBottom {
    public static void main(String[] args){

    }

    private static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }

        return result;
    }
}
