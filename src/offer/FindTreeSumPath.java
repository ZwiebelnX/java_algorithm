package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题34
 */
public class FindTreeSumPath {
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        if(root == null) return result;

        Deque<Integer> path = new ArrayDeque<>();
        int sum = 0;
        findPathCore(root, target, sum, path);

        return result;
    }

    private static void findPathCore(TreeNode node, int target, int sum, Deque<Integer> path){
        sum += node.val;
        path.offer(node.val);
        if(node.left == null && node.right == null && sum == target){
            result.add(new ArrayList<>(path));
        }
        else{
            if(node.left != null) findPathCore(node.left, target, sum, path);
            if(node.right != null) findPathCore(node.right, target, sum, path);
        }

        path.pollLast();
    }
}
