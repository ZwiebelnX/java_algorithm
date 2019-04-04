package offer;

public class MaxProfit {
    public static void main(String[] args){

    }

    private static int maxProfit(int[] numbers){
        int min = numbers[0];
        int maxDiff = numbers[1] - numbers[0];

        for(int i = 2; i < numbers.length; i++){
            if(numbers[i - 1] < min) min = numbers[i - 1];

            int currDiff = numbers[i] - min;
            if(currDiff > maxDiff) maxDiff = currDiff;
        }

        return maxDiff;
    }
}
