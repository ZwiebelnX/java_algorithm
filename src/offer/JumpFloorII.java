package offer;

public class JumpFloorII {
    public static void main(String[] args){

    }

    private static int jumpFloorII(int target){
        if(target <= 0){
            return 0;
        }
        int[] opt = new int[target];

        opt[0] = 1;
        if(target >= 2){
            opt[1] = 2;

            for(int i = 2; i < opt.length; i++){
                opt[i] = 1;
                for(int j = 0 ; j < i; j++){
                    opt[i] += opt[j];
                }
            }
        }
        return opt[target - 1];
    }
}
