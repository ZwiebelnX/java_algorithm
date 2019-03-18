package leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * questionIndex: 874
 */
public class WalkingRobotSimulation {
    private static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        //精髓所在，由于本题的范围是从-30000到30000，完全可以就此进行编码
        //编码之后，有两大优点，一点就是可以将两个有关但是分离的变量整合到一起
        //另一点就是在比较的时候比遍历一个二维数组要快速的多
        //同时Set的插入本身就是有序的，比较速度进一步加快
        //此处的编码就是将x与y转为正数，x为高位，y为低位
        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            //注意左右转的逻辑
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    //比较两个编码值
                    //由于是用的HashSet比较，所以速度较快
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] commands = {4,-1,4,-2,4};
        int[][] ob = {{2,4}};
        System.out.println(robotSim(commands, ob));
    }
}
