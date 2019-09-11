package work.huanju;

import java.util.Scanner;

/**
 * <p>Title: Three</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = null;
        int index = 0;
        while (in.hasNextInt()) {
            int key = in.nextInt();
            if (in.hasNextInt()) {
                if (root == null) {
                    root = new TreeNode(in.nextInt(), index);
                } else {
                    TreeNode node = root;
                    TreeNode parent;

                    while (true) {
                        if (node.key == key) {
                            node.value = index;
                        } else if (node.key > key) {
                            parent = node;
                            node = node.left;
                            if (node == null) {
                                node = new TreeNode(key, index);
                                parent.left = node;
                                break;
                            }
                        } else {
                            parent = node;
                            node = node.right;
                            if (node == null) {
                                node = new TreeNode(key, index);
                                parent.right = node;
                                break;
                            }
                        }
                    }
                }
                index++;
            } else {
                System.out.println(findLastIndex(key, root));
                break;
            }
        }


    }

    private static int findLastIndex(int key, TreeNode node) {
        if (node.key == key) {
            return node.value;
        } else {
            if (key < node.key) {
                node = node.left;
            } else {
                node = node .right;
            }
            return findLastIndex(key, node);
        }
    }
}

class TreeNode{
    int key;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
