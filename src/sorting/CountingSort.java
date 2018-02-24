package sorting;

import mains.ArrayMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CountingSort {

    private static List<Integer> initializeArray(int size) {
        List<Integer> arr = new ArrayList<>();
        IntStream.range(0,size+1).forEach(i -> {
            arr.add(0);
        });
        return arr;
    }

    private static List<Integer> countingSort(List<Integer> arr) {
        if(arr.size() == 1)
            return arr;
        Integer max = Collections.max(arr);

        List<Integer> buckets = initializeArray(max);

        //count occurrences and add to respective buckets
        arr.stream().forEach(i -> {
            if(buckets.get(i) == 0)
                buckets.set(i, new Integer(1));
            else {
                Integer val = buckets.get(i);
                val++;
                buckets.set(i,val);
            }
        });

        //sum up counts
        Integer cumulativeCount = 0;
        for(int i=0;i<buckets.size();i++) {
            int val = buckets.get(i);
            cumulativeCount += val;
            buckets.set(i,cumulativeCount);
        }

        List<Integer> sortedArray = initializeArray(arr.size());

        arr.stream().forEach(i -> {
            Integer storedIndex = buckets.get(i);
            sortedArray.set(storedIndex, i);
            storedIndex--;
            buckets.set(i,storedIndex);
        });
        return sortedArray;
    }

    public static void main(String[] args) {
        Function<List<Integer>, List<Integer>> sortingAlgo = CountingSort::countingSort;
        ArrayMain.runSortingArray(sortingAlgo);
    }
}
