package linkedlist;

import util.ConsoleUtil;
import util.LinkedListUtil;

import java.util.Arrays;
import java.util.List;

public class SumReverseOrderedLinkedList {

    private static LinkedListNode<Integer> sumLinkedList(LinkedListNode<Integer> hN1, LinkedListNode<Integer> hN2) {
        if(hN1 == null && hN2 == null) {
            return null;
        }
        if(hN2 == null)
            return hN1;

        if(hN1 == null)
            return hN2;

        int carry = 0;
        LinkedListNode<Integer> hS = new LinkedListNode(null),
                curS = hS,
                ptr1 = hN1,
                ptr2 = hN2;

        while(ptr1!=null && ptr2!=null) {
            int a=0,
                    b=0;
            if(ptr1!=null) {
                a = ptr1.getData();
                ptr1 = ptr1.next;
            }
            if(ptr2!=null) {
                b = ptr2.getData();
                ptr2 = ptr2.next;
            }
            int nodeSum = a + b + carry;
            carry = nodeSum /10;
            curS.setData(new Integer(nodeSum%10));
            LinkedListNode newLinkedListNode = new LinkedListNode(null);
            curS.next = newLinkedListNode;
            curS = curS.next;
        }

        if(carry>0) {
            curS.setData(carry);
            curS.next = null;
        } else {
            curS = null;
        }
        return hS;
    }

    public static void main(String[] args) {
        List<LinkedListNode> listA = Arrays.<LinkedListNode> asList(
                LinkedListUtil.createFromList(Arrays.<Integer>asList(3)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(5)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(4,5,6)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(1,6,4,3,2,5,6,8,9)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(1,6,4,3,2,5,6,8,9))
        );
        List<LinkedListNode> listB = Arrays.<LinkedListNode> asList(
                LinkedListUtil.createFromList(Arrays.<Integer>asList(1)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(8)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(5,4,2)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(1,6,4,3,2,5,6,8,9)),
                LinkedListUtil.createFromList(Arrays.<Integer>asList(1,6,4,3,6,8,9))
        );

        for(int i=0;i<listA.size();i++) {
            ConsoleUtil.println("Input:");
            ConsoleUtil.println("\tNumber1:"+listA.get(i).toString());
            ConsoleUtil.println("\tNumber2:"+listB.get(i).toString());
            LinkedListNode sumLinkedListNode = sumLinkedList(listA.get(i), listB.get(i));
            ConsoleUtil.println("\tSum:"+ sumLinkedListNode.toString());
        }
    }
}

