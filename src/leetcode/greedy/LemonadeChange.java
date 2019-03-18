package leetcode.greedy;

/**
 * questionIndex: 860
 */
public class LemonadeChange {
    private static boolean lemonadeChange(int[] bills) {
        boolean result = true;
        int[] charges = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                charges[0]++;
            }
            if (bill == 10) {
                if (charges[0] != 0) {
                    charges[0]--;
                    charges[1]++;
                } else {
                    result = false;
                    break;
                }
            }
            //20元找零有两种情况：一张10元+一张5元或3张5元
            //注意：找零次序有要求。贪心算法的第二处体现
            //当有10块钱时，应该首先使用10块钱，因为10块钱所能满足的找零情况没有5块钱多
            //如果先使用5块钱找零，那么就可能出现后面需要用到5块时不够找的问题
            if (bill == 20) {
                if(charges[0] >= 1 && charges[1] >= 1){
                    charges[0]--;
                    charges[1]--;
                } else if (charges[0] >= 3) {
                    charges[0] -= 3;
                }
                else{
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(lemonadeChange(bills));
    }
}