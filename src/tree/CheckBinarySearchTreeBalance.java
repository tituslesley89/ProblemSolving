package tree;

import util.ConsoleUtil;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBinarySearchTreeBalance {

    private static int isBalancedHelper(BinaryNode head) {
        if(head == null) {
            return 0;
        }

        int leftLvl = isBalancedHelper(head.left),
                rightLvl = isBalancedHelper(head.right);

        if(leftLvl == -1 || rightLvl == -1 || Math.abs(leftLvl - rightLvl) > 1)
            return -1;

        return 1+ Math.max(leftLvl, rightLvl);
    }

    private static boolean isBalanced(BinaryNode head) {
        return isBalancedHelper(head) == -1? false : true;
    }

    public static void main(String[] args) {
        List<BinaryNode> listOfTrees = new ArrayList<>();

        listOfTrees.add(TreeUtil.createBinarySearchTree(Arrays.asList(7,3,5,1,2,4,6)));
        listOfTrees.add(TreeUtil.createBinarySearchTree(Arrays.asList(4,3,6,1,2,5,7)));

        listOfTrees.stream().forEach(head -> {
            ConsoleUtil.println("Tree:");
            ConsoleUtil.println(head.toString());
            ConsoleUtil.println("isBalanced:"+isBalanced(head));
        });
    }
}
