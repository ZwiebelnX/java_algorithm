package offer;

import offer.FindKthToTail.ListNode;

/**
 * 面试题25
 * @author Zwiebeln_Chan
 *
 */
public class Merge {
	public static void main(String[] args) {
		
	}
	ListNode merge(ListNode list1,ListNode list2) {
		if(list1 == null && list2 == null) return null;
		
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode mergeHead = null;
        ListNode mergeList = null;
        
        while(p1 != null && p2 !=null) {
        	ListNode next = null;
        	if(p1.val < p2.val) {
        		next = p1;
        		p1 = p1.next;
        	}
        	else {
        		next = p2;
        		p2 = p2.next;
        	}
        	
        	if(mergeList == null) {
        		mergeList = next;
        		mergeHead = mergeList;
        	}
        	else {
        		mergeList.next = next;
        		mergeList = mergeList.next;
        	}
        }
        
        if(p1 == null) {
        	mergeList.next = p2;
        }
        
        if(p2 == null) {
        	mergeList.next = p1;
        }
        
        return mergeHead;
        
    }
}