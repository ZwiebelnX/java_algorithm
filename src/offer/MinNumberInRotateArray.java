package offer;

//顺序查找的复杂度为O(n)
//可以使用二分查找将复杂度降为O(log(n))
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }

    private static int minNumberInRotateArray(int[] array){
        return binarySearch(array, 0, array.length - 1);
    }

    //首先使用二分查找
    private static int binarySearch(int[] array, int low, int high){
        int mid = low;
        // 循环退出点1：如果array[low] < array[high]，说明数组本身就是有序的，直接返回array[low]
        if(array[low] >= array[high]){
            mid = (low + high) / 2;
            // 临界状态：当low、high、mid三个位置的值都相等时，没有办法判断最小值是在左边还是右边，只能遍历来搜索
            if(array[low] == array[high] && array[low] == array[mid]){
                return orderSearch(array);
            }
            // 循环退出点2：此时low和high相邻，high指向的就是最小值
            if(low + 1 == high){
                return array[high];
            }
            // 如果mid值大于low，那么说明mid还处于前半个非递减数组中，最小值在mid的右边
            if(array[mid] >= array[low]){
                return binarySearch(array, mid, high);
            }
            // 如果mid值小于high，那么说明mid处于后半个非递减数组中，最小值在mid的左边
            if(array[mid] < array[high]){
                return binarySearch(array, low, mid);
            }
        }
        return array[mid];
    }

    private static int orderSearch(int[] array){
        int min = -1;
        for (int i : array) {
            if(min > i) min = i;
        }
        return min;
    }

    // 顺序查找
//    private static int minNumberInRotateArray(int[] array) {
//        if (array.length <= 0) {
//            return 0;
//        }
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < array[i - 1]) {
//                return array[i];
//            }
//        }
//        return 0;
//    }
}
