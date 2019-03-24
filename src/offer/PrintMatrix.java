package offer;

import java.util.ArrayList;

/**
 * 面试题29
 */
public class PrintMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> result = printMatrix(matrix);
        System.exit(0);
    }

    private static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] direction = {{0, 1},{1,0},{0,-1},{-1,0}};
        int row = 0, col = -1;
        int tryNum = 0;
        int dir = 0;
        while (tryNum < 4) {
            int nextRow = row + direction[dir][0];
            int nextCol = col + direction[dir][1];
            if (nextRow >= matrix.length || nextCol >= matrix[0].length || nextRow < 0 || nextCol < 0 ||
                    visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                tryNum++;
            } else {
                tryNum = 0;
                row = nextRow;
                col = nextCol;
                result.add(matrix[row][col]);
                visited[row][col] = true;
            }
        }

        return result;
    }
}
