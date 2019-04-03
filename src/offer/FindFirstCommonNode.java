package offer;

/**
 * 面试题52
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {

    }

    private static ListNode findFirstCommonNode(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        int length1 = 0, length2 = 0;
        ListNode p1 = list1, p2 = list2;
        while (list1 != null) {
            length1++;
            list1 = list1.next;
        }
        while (list2 != null) {
            length2++;
            list2 = list2.next;
        }

        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) p1 = p1.next;
        } else {
            for (int i = 0; i < length2 - length1; i++) p2 = p2.next;
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return null;
    }
}
