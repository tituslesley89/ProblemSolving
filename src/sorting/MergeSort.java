package sorting;

import mains.ArrayMain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class MergeSort {

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        int aPtr = 0,
            bPtr = 0;

        List<Integer> mergedList = new ArrayList<>();

        while(aPtr < a.size() || bPtr < b.size()) {
            if(aPtr < a.size() && bPtr < b.size()) {
                if (a.get(aPtr) < b.get(bPtr)) {
                    mergedList.add(a.get(aPtr));
                    aPtr++;
                } else {
                    mergedList.add(b.get(bPtr));
                    bPtr++;
                }
            } else if(aPtr < a.size()) {
                mergedList.add(a.get(aPtr));
                aPtr++;
            } else if(bPtr < b.size()){
                mergedList.add(b.get(bPtr));
                bPtr++;
            }
        }

        return mergedList;
    }

    private static List<Integer> mergeSortHelper(List<Integer> arr) {

        if(arr.size() == 1)
            return arr;

        int mid = arr.size()/2;
        List<Integer> a = new ArrayList<>(),
            b = new ArrayList<>();

        IntStream.range(0,mid).forEach(i -> {
            a.add(arr.get(i));
        });

        IntStream.range(mid,arr.size()).forEach(i -> {
            b.add(arr.get(i));
        });

        if(arr.size() == 2) {
            return merge(a,b);
        } else {
            return merge(mergeSortHelper(a), mergeSortHelper(b));
        }
    }

    private static List<Integer> mergeSort(List<Integer> arr) {
        if(arr.size() == 1)
            return arr;
        return mergeSortHelper(arr);
    }

    public static void main(String[] args) {
        Function<List<Integer>, List<Integer>> sortingAlgo = MergeSort::mergeSort;
        ArrayMain.runSortingArray(sortingAlgo);
    }
}
