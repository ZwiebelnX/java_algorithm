package offer;

public class HasPath {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        int rows = 3;
        int cols = 4;
        char[] str = {'b', 'f', 'c', 'e'};
        System.out.println(hasPath(matrix, rows, cols, str));
    }

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] c) {
        // 边界情况判断
        if (matrix.length == 0 || rows < 1 || cols < 1 || c.length == 0) {
            return false;
        }

        // 构造查看矩阵，这里为了访问方便构造了一个二维数组
        boolean[][] visited = new boolean[rows][cols];

        // 循环搜索入口
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j, c, 0, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                       char[] c, int pathLength, boolean[][] visited) {
        // 边界与被查看过的节点直接返回false
        if (col > cols || row > rows || col < 0 || row < 0 || visited[row][col]) {
            return false;
        }

        //如果字符相等，可能是答案路径
        if (c[pathLength] == matrix[row * cols + col]) {
            visited[row][col] = true;
            pathLength++;
            if(pathLength == c.length){
                return true;
            }

            // 回溯法，遍历周围四个相邻元素
            boolean goAhead = hasPathCore(matrix, rows, cols, row, col + 1, c, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row, col - 1, c, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row + 1, col, c, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row - 1, col, c, pathLength, visited);

            // 如果周围四个相邻元素没有一个可以往下走下去的，那么本节点就被放弃
            if (!goAhead) {
                visited[row][col] = false;
            }
            return goAhead;
        }
        else{
            return false;
        }
    }
}
