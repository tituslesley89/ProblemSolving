package linkedlist;

import util.LinkedListUtil;

public class KthLastInLinkedList {

    static <T> LinkedListNode<T> getKthLast(LinkedListNode<T> head, int k) {
        if(head == null)
            return null;

        LinkedListNode<T> cur = head,
                lookAhead = head;

        for(int i=0;i<k; i++ ) {
            if(lookAhead == null && i<k) {
                return null;
            }
            lookAhead = lookAhead.next;
        }

        while(lookAhead.next!=null) {
            cur = cur.next;
            lookAhead = lookAhead.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> linkedList1 = LinkedListUtil.getIntegerLinkedListSample();
        int k = 0;
        System.out.println(linkedList1.toString());
        LinkedListNode kthLast = getKthLast(linkedList1, k);
        System.out.println(k+"th last element:"+kthLast.getData());
    }
}
