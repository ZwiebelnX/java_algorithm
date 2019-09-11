package work.huanju;

import java.util.Scanner;

/**
 * <p>Title: Two</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2019版权</p>
 * <p>Company: </p>
 *
 * @author Zwiebeln_Chan
 * @version V1.0
 */
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = new ListNode(-1);
        ListNode node = head;
//        int[] test = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16};
////        for (int i : test) {
////            ListNode currentNode = new ListNode(i);
////            node.next = currentNode;
////            node = currentNode;
////        }
        while (in.hasNextInt()) {
            ListNode currentNode = new ListNode(in.nextInt());
            node.next = currentNode;
            node = currentNode;
        }
        if (head.next == null) {
            System.out.println("null");
        } else {
            System.out.println(findMiddleNode(head));
        }
    }

    private static int findMiddleNode(ListNode node) {
        ListNode ptr1 = node;
        ListNode ptr2 = node;

        while (ptr1 != null) {
            ptr2 = ptr2.next;

            ptr1 = ptr1.next;
            if (ptr1 == null) break;
            ptr1 = ptr1.next;
        }
        return ptr2.value;
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
