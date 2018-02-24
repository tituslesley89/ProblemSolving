package linkedlist;

import util.LinkedListUtil;

import java.util.Arrays;

public class PartitionLinkedListAroundX {

    private static LinkedListNode<Integer> partitionAroundX(int x, LinkedListNode<Integer> listHead) {
        LinkedListNode<Integer> partitionedList = new LinkedListNode<Integer>(x);
        LinkedListNode<Integer> head = partitionedList,
                tail = partitionedList,
                cursor = listHead;

        while(cursor!=null) {
            LinkedListNode<Integer> newLinkedListNode = new LinkedListNode<Integer>(cursor.getData());
            if(cursor.getData() < x) {
                newLinkedListNode.next = head;
                head = newLinkedListNode;
            } else {
                tail.next = newLinkedListNode;
                tail = newLinkedListNode;
            }
            cursor = cursor.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode listHead = LinkedListUtil.createFromList(Arrays.asList(1,10,4,6,2,3));
        int x = 5;
        System.out.println(partitionAroundX(x,listHead).toString());
    }
}

