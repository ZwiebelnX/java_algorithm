package offer;

public class RectCover {
    public static void main(String[] args){

    }

    private static int rectCover(int target){
        if(target <= 0) return 0;
        int[] opt = new int[target];

        opt[0] = 1;
        if(target >= 2) {
            opt[1] = 2;
            for(int i = 2; i < target; i++){
                opt[i] = opt[i - 1] + opt[i - 2];
            }
        }
        return opt[target - 1];
    }
}
