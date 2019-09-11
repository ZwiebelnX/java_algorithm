package work.huawei;

import java.util.Scanner;

/**
 * <p>Title: Two</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Two{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        n = in.nextInt(); //数组大小
        m = in.nextInt(); //元素个数
        System.out.println((totalSkill(1, n - 1, m) % 1000000007));
    }

    private static int totalSkill(int start, int left, int m){
        if(left == 0) return m - start + 1;

        int total = 0;
        for (int i = start; i <= m; i++){
            total += totalSkill(i, left - 1, m);
        }
        return total;
    }
}
