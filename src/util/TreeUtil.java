package util;

import tree.BinaryNode;

import java.util.List;
import java.util.stream.IntStream;

public class TreeUtil {

    public static BinaryNode generateBinaryTree() {
        BinaryNode head = new BinaryNode(RandomUtil.getRandomNumber());
        int numberOfNodes = RandomUtil.getRandomNumber(0,20);

        IntStream.range(0, numberOfNodes).forEach(v -> {
            BinaryNode pickedNode = pickRandomNode(head);
            pickedNode.setToFreeChild(new BinaryNode(RandomUtil.getRandomNumber()));
        });
        return head;
    }

    public static BinaryNode pickRandomNode(BinaryNode head) {
        if(!head.hasChildren() && !head.isFull())
            return head;

        if(RandomUtil.getRandomNumber(0,1) ==0) {
            return pickRandomNode(head.getLeft());
        } else {
            return pickRandomNode(head.getRight());
        }
    }

    public static BinaryNode createBinarySearchTree(List<Integer> values) {
        BinaryNode head = new BinaryNode(values.get(0));
        values.stream().skip(1).forEach(i -> {
            insertIntoTree(head, i);
        });
        return head;
    }

    public static void insertIntoTree(BinaryNode head, Integer value) {
        if(head.getLeft() == null) {
            head.setLeft(new BinaryNode(value));
            return;
        }
        if(head.getRight() == null) {
            head.setRight(new BinaryNode(value));
            return;
        }

        if(head.getValue() < value) {
            insertIntoTree(head.getRight(), value);
        } else {
            insertIntoTree(head.getLeft(), value);
        }
    }
}
