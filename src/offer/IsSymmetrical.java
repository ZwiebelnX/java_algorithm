package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 面试题28
 */
public class IsSymmetrical {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println(isSymmetrical(root));


    }
    private static boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot, pRoot);
    }

    //两棵树同时遍历，提高效率
    private static boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null || pRoot2 == null){
            return false;
        }

        if(pRoot1.val != pRoot2.val) return false;

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }



    // 使用栈没有办法存储null
//    private static boolean isSymmetrical(TreeNode pRoot)
//    {
//        List<Integer> preTraverse = new ArrayList<>();
//        List<Integer> symTraverse = new ArrayList<>();
//
//        Deque<TreeNode> preStack = new ArrayDeque<>();
//        Deque<TreeNode> symStack = new ArrayDeque<>();
//        preStack.offerFirst(pRoot);
//        symStack.offerFirst(pRoot);
//
//        while (!preStack.isEmpty()){
//            TreeNode node = preStack.poll();
//            if(node != null){
//                preTraverse.add(node.val);
//                if(node.right != null || node.left != null){
//                    preStack.offerFirst(node.right);
//                    preStack.offerFirst(node.left);
//                }
//            }
//            else{
//                preTraverse.add(null);
//            }
//        }
//
//        while (!symStack.isEmpty()){
//            TreeNode node = symStack.poll();
//            if(node != null){
//                symTraverse.add(node.val);
//                if(node.right != null || node.left != null){
//                    symStack.offerFirst(node.left);
//                    symStack.offerFirst(node.right);
//                }
//            }
//            else{
//                symTraverse.add(null);
//            }
//        }
//
//        for(int i = 0; i < preTraverse.size(); i++){
//            if(preTraverse.get(i) == null && symTraverse.get(i) != null) return false;
//
//            if(!preTraverse.get(i).equals(symTraverse.get(i))){
//                return false;
//            }
//        }
//
//
//
//        return true;
//    }
}
