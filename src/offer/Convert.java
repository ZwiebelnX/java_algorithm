package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Convert {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode list = convert(root);

        System.exit(0);

    }

    private static TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;

        List<TreeNode> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = pRootOfTree;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                node = stack.poll();

                if(!result.isEmpty()){
                    result.get(result.size() - 1).right = node;
                    node.left = result.get(result.size() - 1);
                }
                result.add(node);
                //进入右子树
                node = node.right;
            }
        }

        return result.get(0);

    }

}
