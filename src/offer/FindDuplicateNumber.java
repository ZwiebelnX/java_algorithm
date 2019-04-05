package offer;

/**
 * 面试题3
 */
public class FindDuplicateNumber {
    public static void main(String[] args){
        System.out.println(duplicate(new int[0], 0, new int[1]));
    }

    // 比使用哈希表空间效率更高的方法，比较数组下标和数字本身（因为题目有限制：每一个数字都在0到n - 1的范围内）
    // 当然要注意边界条件的判定
    private static boolean duplicate(int[] numbers,int length,int[] duplication) {
        // 注意 numbers == null 和 number.length == 0是不一样的
        if(numbers == null || numbers.length <= 0 || length <= 0){
            duplication[0] = -1;
            return false;
        }

        for(int i = 0; i < length; i++){
            if(numbers[i] > length - 1 || numbers[i] < 0) return false; // 边界2：不符合每个数字在0到n-1的条件

            //当当前数字和下标不同时
            while (numbers[i] != i){

                //如果当前数字和下标为当前数字的数字相同时，表示这是一个重复的数字
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                //否则交换数字，将当前数字放置到正确的位置上
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }
}
