package offer;

/**
 * 面试题13
 * 与面试题12类似
 */
public class RobotMovementCount {

    public static void main(String[] args){
        int threshold = 3, rows = 4, cols = 4;
        System.out.println(movingCount(threshold, rows, cols));
    }

    private static int movingCount(int threshold, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        //注意题目说明：是座标的数位之和小于threshold
        if(row >= rows || row < 0 || col >= cols || col < 0 || visited[row][col] ||
                getDigitSum(row) + getDigitSum(col) > threshold){
            return 0;
        }

        visited[row][col] = true;

        //回溯法：如果当前坐标可达，那么判断周围的四个座标是不是可达（已经计算过可达的不算在内）
        return 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                movingCountCore(threshold, rows, cols, row, col - 1, visited);
    }

    //计算座标数位之和
    private static int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
