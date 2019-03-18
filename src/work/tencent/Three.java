package work.tencent;

import java.util.Scanner;

// 70%
public class Three {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int totalCard = in.nextInt();
        int score = in.nextInt();
        if(totalCard == score){
            System.out.println(1);
        }
        else{
            int winCases = select(totalCard, score);
            int otherCases = 1;
            for(int i = 0; i < totalCard - score; i ++){
                otherCases = otherCases << 1;
            }
            System.out.println((int)((winCases * otherCases) % (1e9+7)));
        }
    }

    private static int select(int n, int m){
        if(n == m || m == 0){
            return 1;
        }
        else{
            int Im = m;
            int In = n;
            int InSubIm = n - m;
            for(int i = n - 1 ; i > 0; i--){
                In *= i;
                if(i < m){
                    Im *= i;
                }
                if(i < (n - m)){
                    InSubIm *= i;
                }
            }
            return In / ((InSubIm) * Im);
        }
    }
}
