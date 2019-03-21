package leetcode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * questionIndex: 496
 */
public class NextGreaterElementI {
    public static void main(String[] args){
        int[] nums1 = {4,3,2,1};
        int[] nums2 = {6,5,4,3,2,1};
        int[] result = nextGreaterElement(nums1, nums2);
        System.exit(0);
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums1.length];

        stack.offerFirst(nums2[0]);

        for(int i = 1; i < nums2.length; i++){
            if(stack.isEmpty() || nums2[i] <= stack.peek()){
                stack.offerFirst(nums2[i]);
            }
            else{
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put(stack.poll(), nums2[i]);
                }
                stack.offerFirst(nums2[i]);
            }
        }

        for(int i = 0; i < nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
