package sort;

public class HeapSort {
    private static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始，直至根节点（从下往上排序）
        //叶子节点没有必要进入这个函数，因为他们没有办法向下移动
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToTop(array, i, array.length);
        }
    }

    private static void adjustDownToTop(int[] array, int k, int length) { //length是用来限定排序的。在交换根节点和叶子节点时，树会变小
        int temp = array[k]; //要调整的节点
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) { //初始化循环为直接左子节点，每次步进至子树的左节点
            if (i + 1 < length && array[i] < array[i + 1]) { //寻找左右两个最大的那个子节点
                i++;
            }
            if (temp >= array[i]) { //对于大顶堆，如果要调整的节点已经大于他的两个子节点
                break; //退出调整循环
            } else {
                array[k] = array[i]; //将被交换的节点上移 注意此时要调整的节点还没赋值到位 这样实际上简化了操作
                k = i; //【关键】 更新k到现在的位置 以便后面的循环向下调整
            }
        }
        array[k] = temp; //放置节点至正确的位置
    }

    private static void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) { //堆排序的过程
            //在链表中，交换第一个和最后一个的位置。因为在大顶堆里第一个一定是最大的，然后将其放置在链表末尾，那么他的排序位置就一定是正确的
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDownToTop(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 7, 2, 3, 4, 1, 8, 9, 6};
        //long start = System.currentTimeMillis();
        heapSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        //System.out.println((System.currentTimeMillis() - start));
    }
}
