package sorting;

import mains.ArrayMain;

import java.util.List;

public class QuickSort {

    private static void quickSortHelper(List<Integer> arr, Integer l, Integer r) {
        if(l>=r || l<0)
            return;

        Integer mid = (l+r+1)/2;
        int kIndex = partitionAround(arr, l, r, mid);

        quickSortHelper(arr,l,kIndex-1);
        quickSortHelper(arr,kIndex+1,r);
    }

    private static void swap(List<Integer> arr, int a, int b) {
        if(a==b)
            return;
        Integer temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static int partitionAround(List<Integer> arr, int l, int r, int pivotIndex) {

        int pivot = arr.get(pivotIndex),
            j=l-1;
        swap(arr,pivotIndex,r);

        for(int i=l;i<=r-1;i++) {
            if(arr.get(i)<=pivot) {
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,j+1,r);
        return j+1;
    }

    private static void quickSort(List<Integer> arr) {
        quickSortHelper(arr,0,arr.size()-1);
    }

    public static void main(String[] args) {
        ArrayMain.runSortingArray(QuickSort::quickSort);
    }
}
