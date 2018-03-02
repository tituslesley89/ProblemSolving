package find;

import util.ArrayUtil;
import util.ConsoleUtil;

import java.util.List;

public class FindKSmallestInUnsortedArray {

    private static Integer findKthHelper(List<Integer> arr, int l, int r, int k) {

        if(k > 0 && r - l > k) {

        }

        return Integer.MAX_VALUE;
    }

    private static Integer findKthSmallest(List<Integer> arr, int k) {
        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(false);
        int k=3;

        inputArrays.stream().forEach(arr -> {
            ConsoleUtil.print("Array:");
            ConsoleUtil.printArray(arr);
            ConsoleUtil.newline();
            ConsoleUtil.print("K:");
            ConsoleUtil.println(k+"");
            ConsoleUtil.print("Result:"+findKthSmallest(arr,k));
            ConsoleUtil.newline();
            ConsoleUtil.newline();
        });
    }
}
