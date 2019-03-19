package offer;

public class JumpFloor {
    public static void main(String[] args){
        System.out.println(jumpFloor(1));
    }

    private static int jumpFloor(int target){
        if(target <= 0){
            return 0;
        }
        int[] opt = new int[target];

        opt[0] = 1;
        if(target >= 2){
            opt[1] = 2;

            for(int i = 2; i < opt.length; i++){
                opt[i] = opt[i - 2] + opt[i - 1];
            }
        }
        return opt[target - 1];
    }
}
