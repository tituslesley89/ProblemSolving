package tree;

import util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumHeightBST {

    private static BinaryNode createMinimalBSTHelper(List<Integer> arr, int start, int end) {
        if(end<=start)
            return null;

        int mid = (end+start)/2;
        BinaryNode n = new BinaryNode(arr.get(mid));

        n.setLeft(createMinimalBSTHelper(arr,start,mid));
        n.setRight(createMinimalBSTHelper(arr,mid+1,end));

        return n;
    }

    private static BinaryNode createMinimalBST(List<Integer> arr) {
        return createMinimalBSTHelper(arr,0,arr.size());
    }

    public static void main(String[] args) {
        List<List<Integer>> inputArray = new ArrayList<>();
        inputArray.add(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        inputArray.add(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));

        inputArray.stream().forEach(i -> {
            ConsoleUtil.newline();
            ConsoleUtil.print("Inserting:");
            ConsoleUtil.printArray(i);
            ConsoleUtil.newline();
            ConsoleUtil.print(createMinimalBST(i).toString());
            ConsoleUtil.newline();
        });
    }
}
