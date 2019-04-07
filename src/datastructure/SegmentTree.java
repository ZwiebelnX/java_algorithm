package datastructure;

/**
 * 线段树
 */
public class SegmentTree {
    private static final int MAX_LEN = 100;
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7 ,9, 11};
        int[] tree = new int[MAX_LEN];

        buildTree(arr, tree, 0,0, arr.length - 1);
        updateTree(arr, tree, 0, 0, 5, 4, 6);
        System.out.println(queryTree(tree, 0, 0, 5, 2, 5));

        System.exit(0);
    }

    // 构造树
    private static void buildTree(int[] arr, int[] tree, int node, int start, int end){
        // 出口：当遍历到start == end时为出口
        // 注意 这里同时考虑了没有子节点的节点
        if(start >= end) tree[node] = arr[start];
        else{
            int mid = (start + end) / 2;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;

            // 递归建树
            buildTree(arr, tree, leftNode, start, mid);
            buildTree(arr, tree, rightNode, mid + 1, end);

            // 计算当前结点值，为左节点加上右节点的值（线段树特性）
            tree[node] = tree[leftNode] + tree[rightNode];
        }
    }

    // 更新树
    private static void updateTree(int[] arr, int[] tree, int node, int start, int end, int index, int val){
        // 出口：到达要更改的地方
        if(start >= end){
            arr[index] = val;
            tree[node] = val;
        }
        else{
            int mid = (start + end) / 2;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;

            // 递归更改，注意这里是左右子树的选择，和构造树不同
            if(index >= start && index <= mid){
                updateTree(arr, tree, leftNode, start, mid, index, val);
            }
            else {
                updateTree(arr, tree, rightNode, mid + 1, end, index, val);
            }
            // 重新计算结果
            tree[node] = tree[leftNode] + tree[rightNode];
        }
    }

    // 查找结果
    private static int queryTree(int[] tree, int node, int start, int end , int L, int R){
        // 出口1：如果查询的范围不在当前计算范围内，返回0并停止递归
        if(R < start || L > end) return 0;
        // 出口2： 如果当前的计算范围包含在查询范围内，返回节点的值并停止递归
        if((L > start && R < end) || start >= end) return tree[node];

        int mid = (start + end) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;

        // 递归下降寻找符合要求的节点
        int sumLeft = queryTree(tree, leftNode, start, mid, L, R);
        int sumRight = queryTree(tree, rightNode, mid + 1, end, L, R);
        return sumLeft + sumRight;
    }
}
