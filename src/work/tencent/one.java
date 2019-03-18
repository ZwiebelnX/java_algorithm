package work.tencent;

import java.util.Scanner;

//牛家村硬币问题
public class one {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int max = in.nextInt();
            int mount = in.nextInt();
            System.out.println(mount / max + 1);
        }
    }
}
