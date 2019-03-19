package offer;

/**
 * 面试题13
 * 与面试题12类似
 */
public class RobotMovementCount {
    public static void main(String[] args){
        System.out.println(movingCount(3, 4, 4));
    }

    private static int movingCount(int threshold, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        if(row >= rows || row < 0 || col >= cols || col < 0 || visited[row][col] || row + col > threshold){
            return 0;
        }

        visited[row][col] = true;

        return 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                movingCountCore(threshold, rows, cols, row, col - 1, visited);
    }
}
