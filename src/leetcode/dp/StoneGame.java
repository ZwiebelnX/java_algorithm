package leetcode.dp;

/**
 * questionIndex: 877
 */
public class StoneGame {

    public static void main(String[] args){
        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }

    private static boolean stoneGame(int[] piles) {
        int head = 0;
        int tail = piles.length - 1;
        int sum = 0;
        int have = 0;
        for(int i = 0; i < piles.length - 1; i++){
            int get = piles[head] >= piles[tail] ? piles[head] : piles[tail];
            sum += get;
            if(i % 2 ==0){
                have += get;
            }
        }
        return have >= sum / 2;
    }
}
