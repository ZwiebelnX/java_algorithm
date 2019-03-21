package offer;

import java.util.Queue;
import java.util.LinkedList;

public class ReOrderArray {
    public static void main(String[] args){
        int[] array = {1,5,4,2,3};
        reOrderArray(array);
        System.exit(0);
    }

    private static void reOrderArray(int [] array) {
        if(array.length == 0 || array.length == 1){
            return;
        }
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> sigQueue = new LinkedList<>();

        for(int a : array){
            if((a & 1) == 0){
                oddQueue.offer(a);
            }
            else{
                sigQueue.offer(a);
            }
        }

        for(int i = 0; i < array.length; i++){
            if(!sigQueue.isEmpty()){
                array[i] = sigQueue.poll();
            }
            else{
                array[i] = oddQueue.poll();
            }
        }
    }
}
