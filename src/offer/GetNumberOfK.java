package offer;

public class GetNumberOfK {
    public static void main(String[] args){
        int[] array = {3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(array, 3));
    }

    private static int getNumberOfK(int[] array, int k){
        if(array.length == 0) return 0;

        int start = getFirstK(array, k, 0, array.length - 1);
        int end = getLastK(array, k, 0, array.length - 1);
        if(start > -1 && end > -1) return end - start + 1;
        return 0;
    }

    private static int getFirstK(int[] array, int k, int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] == k && (mid - 1 < 0 || array[mid - 1] != k)) return mid;
            else{
                if(array[mid] < k) return getFirstK(array, k, mid + 1, high);
                else return getFirstK(array, k, low, mid - 1);
            }
        }
        return -1;
    }

    private static int getLastK(int[] array, int k, int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            if(array[mid] == k && (mid + 1 >= array.length || array[mid + 1] != k)) return mid;
            else{
                if(array[mid] > k) return getLastK(array, k, low, mid - 1);
                else return getLastK(array, k, mid + 1, high);
            }
        }
        return -1;
    }
}
