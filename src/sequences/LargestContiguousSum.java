package sequences;

import mains.ArrayMain;
import util.ConsoleUtil;

import java.util.List;
import java.util.function.Consumer;

public class LargestContiguousSum {


    private static void largestContiguousSum(List<Integer> arr) {
        if(arr.size() == 0) {
            ConsoleUtil.println("Array is empty");
        }
        if(arr.size() ==1) {
            ConsoleUtil.println("Largest Sum:"+arr.get(0));
        }

        int maxSum = 0,
            curMinIndex = 0,
            curMaxIndex = 0,
            maxIndex = 0,
            minIndex = 0,
            currentSum = 0;

        for(int i=0;i<arr.size();i++) {
            currentSum += arr.get(i);
            if(currentSum > maxSum) {
                maxSum = currentSum;
                curMaxIndex = i;
                maxIndex = curMaxIndex;
                minIndex = curMinIndex;
            } else if(currentSum < 0){
                currentSum = 0;
                curMinIndex = i+1;
            }
        }

        ConsoleUtil.println("The maximum sum in the sequence was "+maxSum+" between {"+minIndex+","+maxIndex+"}");
    }

    public static void main(String[] args) {
        Consumer<List<Integer>> consumer = LargestContiguousSum::largestContiguousSum;
        ArrayMain.FindSequenceHelper(consumer, true);
    }
}
