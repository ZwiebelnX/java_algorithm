package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PrintTreeNodeInZhi {
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

        Deque<TreeNode> LR = new ArrayDeque<>();
        Deque<TreeNode> RL = new ArrayDeque<>();

        LR.offerLast(pRoot);
        int preCount = 1, count = 0;
        int high = 1;

        ArrayList<Integer> row = new ArrayList<>();

        while (!LR.isEmpty() || !RL.isEmpty()){
            TreeNode node;
            if(high % 2 == 0){
                node = RL.pollFirst();
                preCount--;
                if(node.right != null){
                    LR.offerFirst(node.right);
                    count++;
                }
                if(node.left != null){
                    LR.offerFirst(node.left);
                    count++;
                }
            }
            else{
                node = LR.pollFirst();
                preCount--;
                if(node.left != null){
                    RL.offerFirst(node.left);
                    count++;
                }
                if(node.right != null){
                    RL.offerFirst(node.right);
                    count++;
                }
            }
            row.add(node.val);
            if(preCount == 0){
                ans.add(row);
                row = new ArrayList<>();
                preCount = count;
                count = 0;
                high++;
            }
        }
        return ans;
    }
}
