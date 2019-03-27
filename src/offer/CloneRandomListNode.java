package offer;

/**
 * 面试题35
 */
public class CloneRandomListNode {
    private RandomListNode clone(RandomListNode pHead) {
        if(pHead == null) return null;
        cloneList(pHead);
        cloneRandom(pHead);
        return separateList(pHead);
    }

    private void cloneList(RandomListNode pHead){
        RandomListNode node = pHead;
        while (node != null){
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private void cloneRandom(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode cloneNode = pHead.next;
        while (node != null){
            if(node.random != null) cloneNode.random = node.random.next;
            node = cloneNode.next;
            if(node != null) cloneNode = node.next;
        }
    }

    private RandomListNode separateList(RandomListNode pHead){
        RandomListNode cHead = pHead.next;
        RandomListNode node = pHead;
        RandomListNode cloneNode = pHead.next;
        while (node != null){
            node.next = cloneNode.next;
            node = cloneNode.next;
            if(node != null){
                cloneNode.next = node.next;
                cloneNode = cloneNode.next;
            }
        }

        return cHead;
    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
