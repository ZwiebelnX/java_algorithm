package work.huawei;

import com.sun.deploy.util.OrderedHashSet;

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
public class One{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] attrs = new int[100];
        int length = 0;
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        while (in.hasNext() && in.hasNextInt()){
            attrs[length] = in.nextInt();
            if(max < attrs[length]){
                maxIndex = length;
                max = attrs[length];
            }
            length++;
        }

        for (int i = 0; i < length; i++)



        System.out.println(isTailReachable(attrs, length));
    }

    private static int isTailReachable(int[] attrs, int length){
        int currentValue;
        int currentIndex;
        int minTotal = Integer.MAX_VALUE;
        for (int i = 1; i < (length / 2); i++){
            int currentTotal = 1;
            currentValue = attrs[i];
            currentIndex = i;
            do{
                currentTotal++;
                currentIndex += currentValue;
                currentValue = attrs[currentIndex];

                if(currentTotal > minTotal) break;
                if (currentIndex == (length - 1)){
                    minTotal = Math.min(minTotal, currentTotal);
                    break;
                }
            } while (currentIndex < length);
        }
        if (minTotal == Integer.MAX_VALUE){
            return -1;
        }
        return minTotal;
    }

}
