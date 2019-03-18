package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class PrintListFromTailToHead {

    private class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
        this.val = val;
        }
    }

    public static void main(String[] args){

    }

    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> stack = new ArrayList<>();
        if(listNode == null){
            return stack;
        }

        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(stack);

        return stack;
    }
}
