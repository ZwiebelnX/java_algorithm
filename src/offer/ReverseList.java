package offer;

public class ReverseList {
	//有头链表情况下
	public static void main(String[] args) {
		ListNode head = new ListNode(-1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		head = reverseList(head);
		
		System.exit(0);
	}
	
	public static ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
        ListNode pre = head, node = head, next = head;
        node = head.next;
        if(node.next == null) {
        	return head;
        }
        
        //初始化头三个节点
        pre = node;
        node = node.next;
        next = node.next;
        
        //头结点的next指向null 作为尾节点
        pre.next = null;
        
        while(next != null) {
        	node.next = pre;
        	pre = node;
        	node = next;
        	next = node.next;
        }
        
        node.next = pre;
        head = node;
        
        return head;
    }
	
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
