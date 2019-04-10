package leetcode;

/**
 * questionIndex: 237
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args){

    }

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }