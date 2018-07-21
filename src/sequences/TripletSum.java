package sequences;

import util.ConsoleUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of positive intergers. Find the triplets that sum upto a value K.
 * The array does not fit into memory.
 */
public class TripletSum {

    public static boolean findTriplet(int[] arr, int k) {
        int[] kBuckets = new int[k];

        for(int i=0;i<k;i++) {
            kBuckets[i] = 0;
        }

        for(int i=0;i<arr.length;i++) {
            int current = arr[i];
            kBuckets[current] = 1;
            for(int j=1;j<k;j++) {
                Set<Integer> ignore = new HashSet<>();
                if(kBuckets[j] > 0 && kBuckets[j] < 3) {
                    if(j+current < k && !ignore.contains(j + current)) {
                        if(kBuckets[j + current] == 0) {
                            kBuckets[j + current] = 1;
                        } else {
                            kBuckets[j + current] = Math.min(kBuckets[j+current], kBuckets[j]+1);
                        }
                        ignore.add(j + current);
                    }
                }
            }
        }

        if(kBuckets[k-1] == 3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,10,15,20,11,60};
        int k = 35;
        System.out.println(findTriplet(input, k));
    }
}
