package sort;

/**
 * 归并排序
 * 参考网址：https://www.cnblogs.com/of-fanruice/p/7678801.html
 *
 * 算法分析：
 * （1）稳定性
 *      　归并排序是一种稳定的排序。
 * （2）存储结构要求
 *     　可用顺序存储结构。也易于在链表上实现。
 * （3）时间复杂度
 *     　对长度为n的文件，需进行趟二路归并，每趟归并的时间为O(n)，故其时间复杂度无论是在最好情况下还是在最坏情况下均是O(nlgn)。
 * （4）空间复杂度
 *    　 需要一个辅助向量来暂存两有序子文件归并的结果，故其辅助空间复杂度为O(n)，显然它不是就地排序。
 *   注意：
 *     　若用单链表做存储结构，很容易给出就地的归并排序
 */
public class MergeSort {
    private static void sort(int[] a, int low, int high){
        int mid = (high + low ) / 2; //分为左右分支

        //当当前数组元素不为1时
        if(low < high){
            //分治
            //两个分支分别归并排序，使得左右分支都有序
            sort(a, low, mid);
            sort(a, mid + 1, high);

            merge(a, low, mid, high); //归并左右分支
        }
    }

    private static void merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high - low + 1]; //申请空间
        int pointerLeft = low; //左分支游标
        int pointerRight = mid + 1; //右分支游标
        int pointerTemp = 0; //临时数组游标

        //合并左右分支
        //注意，这里的左右分支本身就是有序的
        while(pointerLeft <= mid && pointerRight <= high){
            //使用++的技巧
            temp[pointerTemp++] = a[pointerLeft] < a[pointerRight] ? a[pointerLeft++] : a[pointerRight++];
        }
        //左右分支合并完成

        //合并多余元素的分支，直接将元素添加至链表尾部
        while(pointerLeft <= mid){
            temp[pointerTemp++] = a[pointerLeft++];
        }
        while(pointerRight <= high){
            temp[pointerTemp++] = a[pointerRight++];
        }

        //覆盖原数组对应的子数组
        if (temp.length >= 0) System.arraycopy(temp, 0, a, low, temp.length);
    }

    public static void main(String[] args){
        int[] a = {49, 38, 65, 97, 76, 13, 27};
        MergeSort.sort(a, 0, a.length - 1);
        for(int x : a){
            System.out.print(x + " ");
        }
    }
}
