package offer;

/**
 * 面试题23
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    // 快慢指针 查看当前链表是否存在环
    private static ListNode meetingNode(ListNode head) {
        if (head == null) return null;

        ListNode pSlow = head.next;
        if (pSlow == null) return null;

        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            if (pFast == pSlow) return pFast;

            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) pFast = pFast.next;
        }

        return null;
    }

    private static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) return null;

        int nodesInLoop = 1;
        // 计算环内节点个数
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            nodesInLoop++;
        }

        // 寻找入口
        // 先将p1向前移动，次数为环内节点的数目
        node1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            node1 = node1.next;
        }

        // p1和p2一起移动，当他们相遇时，p1刚好走完一圈（p1和p2的距离就是环内节点的个数），相遇的节点就是环入口
        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


}
