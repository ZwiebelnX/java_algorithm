package offer;


public class SerializeTree {
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

        System.out.println(serialize(root));
        TreeNode  root2 = deserialize(serialize(root));
    }

    private static String serialize(TreeNode root){
        StringBuilder ans = new StringBuilder();
        if(root == null){
            ans.append("$");
            return ans.toString();
        }
        serializeCore(root, ans);
        return ans.toString();
    }

    private static void serializeCore(TreeNode root, StringBuilder ans){
        if(root == null){
            if(ans.length() != 0) ans.append(",");
            ans.append("$");
        }
        else{
            if(ans.length() != 0) ans.append(",");
            ans.append(root.val);
            serializeCore(root.left, ans);
            serializeCore(root.right, ans);
        }
    }

    private static TreeNode deserialize(String str) {
        String[] nodes = str.split(",");
        if(nodes.length == 0 || nodes[0].equals("$")) return null;

        return deserializeCore(nodes);
    }

    private static int index = -1;

    private static TreeNode deserializeCore(String[] nodes) {
        index++;
        if(!nodes[index].equals("$")) {
            TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = deserializeCore(nodes);
            root.right = deserializeCore(nodes);
            return root;
        }
        return null;
    }

}
