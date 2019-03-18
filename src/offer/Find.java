package offer;

/**
 * 二维数组中的查找
 */
public class Find {
    public static void main(String[] args){
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {4, 7, 10 ,13}};
        System.out.println(find(target, array));
    }

    private static boolean find(int target, int [][] array) {
        if(array.length == 0){
            return false;
        }

        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0){
            if(array[row][col] == target) return true;
            else if(array[row][col] < target) row++;
            else if(array[row][col] > target) col--;
        }

        return false;

    }
}
