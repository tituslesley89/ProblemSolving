package linkedlist;

import util.LinkedListUtil;

public class DeleteWithLimitedAccess {

    static <T> void deleteWithLimitedAccess(LinkedListNode<T> k) {
        if(k == null)
            return;

        if(k.next == null) {
            k = null;
            return;
        }

        k.data = (T) k.next.data;
        k.next = k.next.next;
    }

    public static void main(String[] args) {
        int k = 4;
        LinkedListNode<Integer> integerLinkedListSample = LinkedListUtil.getIntegerLinkedListSample();
        System.out.println(integerLinkedListSample.toString());
        deleteWithLimitedAccess(integerLinkedListSample.getAccessToNode(k));
        System.out.println("LinkedList after removing element "+k);
        System.out.println(integerLinkedListSample.toString());
    }
}
