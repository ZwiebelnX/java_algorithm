package work.thoughtworks;

/**
 * <p>Title: PraseMap</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class ParseMap {
    public static void main(String[] args) {

    }

    public String[][] parseMap(String[][] data, int[] mapSize) {
        String[][] map = new String[mapSize[0]][mapSize[1]];
        int currentCol = 0;
        int currentRow = 0;
        boolean isReverse = false;
        for (String[] datum : data) {
            /* inject data into map array */
            currentCol = !isReverse ? currentCol + 2 : currentCol - 2;
            if (currentCol > mapSize[1] - 1 || currentCol < 0) {

                // 处理行数为偶数的情况
                currentRow += 2;
                if (currentRow > mapSize[0] - 1) {
                    currentRow = mapSize[0] - 1;
                }

                // 处理正序和倒序
                if (!isReverse) {
                    currentCol = mapSize[1] -1;
                    isReverse = true;
                }
                else {
                    currentCol = 0;
                    isReverse = false;
                }
            }
        }
        return map;
    }
}
