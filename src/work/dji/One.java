package work.dji;

import java.util.Scanner;

/**
 * <p>Title: One</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int bugCount = in.nextInt();
            int[] bugList = new int[bugCount];
            int buff = in.nextInt();
            int maxCoffee = in.nextInt();
            int totalNeed = 0;
            for(int i = 0; i < bugCount; i++){
                bugList[i] = in.nextInt();
                totalNeed += bugList[i];
            }
            int buffTime = maxCoffee * buff * 60;
            int totalTime = buffTime + (8 - maxCoffee) * 60;
            if(totalNeed > totalTime) System.out.println(0);
            else{
                if(totalNeed - buffTime < 0){
                    int result = 60 * maxCoffee - (buffTime - totalNeed) / buff;
                    System.out.println(result);
                }
                else{
                    System.out.println(maxCoffee * 60 + (totalNeed - buffTime));
                }
            }
        }

    }
}
