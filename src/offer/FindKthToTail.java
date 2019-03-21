package offer;

public class FindKthToTail {
    public static void main(String[] args){

    }

    private static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        if(head.next.next == null){
            return head.next;
        }
        ListNode node = head.next;
        ListNode Kth = null;
        int index = 0;
        while(node.next != null){
            node = node.next;
            index++;

            if(index == k - 1){
                Kth = head.next;
            }
            if(index > k - 1){
                Kth = Kth.next;
            }
        }

        return Kth;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
