package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * questionIndex: 94
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args){

    }

    List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            //如果节点非空 将自己入栈并指向左子树
            if(node != null){
                stack.offerFirst(node);
                node = node.left;
            }
            //如果当前节点为空
            //注意 此处如果是叶子节点的话将会poll两次。
            //第一次是自己，第二次是他的根节点，将根节点poll出去之后将会指向根节点的右子树
            else{
                node = stack.poll();
                result.add(node.val);
                //进入右子树
                node = node.right;
            }
        }
        return result;
    }
}
