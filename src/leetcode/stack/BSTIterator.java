package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Title: BSTIterator</p>
 * <p>Description: 173，要求next和hasNext的复杂度都为O(1)，空间复杂度为O(h)，h=树高</p>
 *
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = null;
        TreeNode currentNode = stack.poll();
        if (currentNode != null) {
            node = currentNode.right;
        }
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return currentNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        root.left = node3;
        root.right = node15;
        node15.left = node9;
        node15.right = node20;

        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}