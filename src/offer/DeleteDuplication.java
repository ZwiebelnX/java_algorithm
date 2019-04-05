package offer;

public class DeleteDuplication {
    public static void main(String[] args){

    }

    // 注意，此处传入的是无头节点的链表。意思就是传入的结点一样可能会被删除
    private static ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return null;

        ListNode preNode = null;    // 前一个节点
        ListNode node = pHead;      //当前节点，初始化为head
        while (node != null){
            ListNode next = node.next;
            boolean needDelete = false;
            if(next != null && next.val == node.val) needDelete = true; //下一个节点的值和当前的值一样，那么准备删除

            // 向前移动
            if(!needDelete){
                preNode = node;
                node = node.next;
            }
            else{
                // 删除重复的节点
                int value = node.val;
                ListNode toBeDelete = node;
                while(toBeDelete != null && toBeDelete.val == value){
                    next = toBeDelete.next;

                    toBeDelete = next;
                }

                //重新组织链表
                if(preNode == null) pHead = next; //如果删除的是头结点
                else preNode.next = next;
                node = next;
            }
        }
        return pHead;
    }
}
