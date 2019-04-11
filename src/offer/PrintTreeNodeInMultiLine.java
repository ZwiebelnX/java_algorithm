package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 */
public class PrintTreeNodeInMultiLine {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println(print(root));
    }

    private static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(pRoot == null) return ans;

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offerLast(pRoot);
        ArrayList<Integer> row = new ArrayList<>();

        int preCount = 1, count = 0;

        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            preCount--;
            row.add(node.val);
            if(node.left != null){
                queue.offerLast(node.left);
                count++;
            }
            if(node.right != null){
                queue.offerLast(node.right);
                count++;
            }

            if(preCount == 0){
                preCount = count;
                count = 0;
                ans.add(row);
                row = new ArrayList<>();
            }
        }
        return ans;
    }
}
