package work.zijie;

import java.util.Scanner;

public class Three {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        int[] result = new int[cases];

        for(int i = 0; i < cases; i++){
            int total = in.nextInt();
            int[] scores = new int[total];
            int[] gift = new int[total];

            for(int j = 0; j < total; j++){
                scores[j] = in.nextInt();
                if(scores[j] == 0){
                    gift[j] = 1;
                }
                else{
                    gift[j] = scores[j];
                }
            }

            for(int j = total; j < 2 * total; j++){
                int leftGift = gift[((j + 1) % total)];
                int rightGift = gift[((j - 1) % total)];

                if(gift[(j % total)] == Math.min(leftGift, rightGift));
                else if(gift[(j % total)] == Math.max(leftGift, rightGift)){
                    gift[(j % total)] = Math.min(leftGift, rightGift) + 1;
                }
                else if(gift[(j % total)] > Math.max(leftGift, rightGift)){
                    gift[(j % total)] = Math.max(leftGift,rightGift) + 1;
                }
                else if(gift[(j % total)] < Math.min(leftGift, rightGift)){
                    gift[(j % total)] = 1;
                }
                else{
                    gift[(j % total)] = Math.min(leftGift, rightGift) + 1;
                }
            }

            for(int j = 0; j < total; j++){
                result[i] += gift[j];
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
