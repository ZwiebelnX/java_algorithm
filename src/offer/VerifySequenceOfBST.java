package offer;

/**
 * 面试题33
 */
public class VerifySequenceOfBST {
    public static void main(String[] args) {
        int[] sequence = {7,4,6,5};
        System.out.println(verifySequenceOfBST(sequence));
    }

    private static boolean verifySequenceOfBST(int[] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return verifyCore(sequence, 0, sequence.length - 1);
    }

    private static boolean verifyCore(int[] sequence, int low, int high){
        int root = sequence[high];

        //获取左子树
        int mid = low;
        for(; mid < high; mid++){
            if(sequence[mid] > root) break;
        }

        //判断右子树是否符合二叉树定义
        for(int i = mid ; i < high; i++){
            if(sequence[i] <= root) return false;
        }

        //如果还有子树则递归
        boolean left = true;
        if(mid > low) left = verifyCore(sequence, low, mid - 1);

        boolean right = true;
        if(mid + 1 < high) right = verifyCore(sequence, mid, high - 1);

        return (left && right);
    }

    // 无法处理左右子树节点不一致的情况
//    private static boolean verifyCore(int[] sequence, int low, int high) {
//        if(low >= high) return true;
//        int root = sequence[high];
//        int mid = (high + low - 1) / 2;
//
//        for (int i = 0; i <= mid; i++) {
//            if (sequence[i] > root) return false;
//        }
//        for (int i = mid + 1; i < high; i++) {
//            if (sequence[i] <= root) return false;
//        }
//
//        return verifyCore(sequence, low, mid) && verifyCore(sequence, mid + 1, high - 1);
//    }
}
