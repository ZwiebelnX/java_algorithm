package leetcode.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>Title: TreePreorderTraversal</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class TreePreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return  result;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();

            // 注意：因为是压入栈，所以一定要右边在左边前压入栈，要不然取出顺序不正确！
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            result.add(node.val);
        }
        return result;
    }
}
