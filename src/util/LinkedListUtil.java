package util;

import linkedlist.LinkedListNode;

import java.util.Arrays;
import java.util.List;

public class LinkedListUtil {

    public static <T> LinkedListNode<T> createFromList(List<T> listOfElements) {

        if(listOfElements.isEmpty())
            return null;

        LinkedListNode<T> head = new LinkedListNode(listOfElements.get(0));
        LinkedListNode<T> tail = head;

        for(int i=1;i<listOfElements.size();i++) {
            LinkedListNode<T> newLinkedListNode = new LinkedListNode<>(listOfElements.get(i));
            tail.next = newLinkedListNode;
            tail = newLinkedListNode;
        }

        return head;
    }

    public static LinkedListNode<Integer> getIntegerLinkedListSample() {
        return createLinkedListFromArray(Arrays.asList(0,1,2,3,4,5));
    }

    private static <T> LinkedListNode createLinkedListFromArray(List<T> sampleDataList) {
        if(sampleDataList.size() == 0)
            return new LinkedListNode(0);

        LinkedListNode<T> head = new LinkedListNode(sampleDataList.get(0));
        LinkedListNode<T> current = head;
        for(int i=1;i<sampleDataList.size();i++) {
            LinkedListNode next = new LinkedListNode(sampleDataList.get(i));
            current.next = next;
            current = current.next;
        }
        return head;
    }
}
