package offer;

/**
 * 面试题51
 * 允许修改原数组的情况下
 * 牛客网上有大数据，注意% 1000000007的问题
 */
public class InversePairs {
    public static void main(String[] args){
        int[] array = {7, 5, 6, 4};
        System.out.println(inversePairs(array));
    }

    private static int inversePairs(int[] array){
        if(array.length == 0) return 0;
        return mergeSort(array, 0, array.length - 1);
    }

    private static int mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid = (high + low) / 2;
            int count = 0;

            count += mergeSort(array, low, mid);
            count += mergeSort(array, mid + 1, high);
            count += mergeAndCount(array, low, mid, high);
            return count;
        }
        else{
            return 0;
        }
    }

    private static int mergeAndCount(int[] array, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int pLow = mid;
        int pHigh = high;
        int pTemp = high - low;
        int count = 0;
        while (pLow >= low && pHigh >= mid + 1){
            if(array[pLow] > array[pHigh]){
                count += pHigh - (mid + 1) + 1;
                temp[pTemp--] = array[pLow--];
            }
            else{
                temp[pTemp--] = array[pHigh--];
            }
        }

        while (pLow >= low){
            temp[pTemp--] = array[pLow--];
        }
        while (pHigh >= mid + 1){
            temp[pTemp--] = array[pHigh--];
        }

        if (high + 1 - low >= 0) System.arraycopy(temp, 0, array, low, high + 1 - low);

        return count;
    }
}
