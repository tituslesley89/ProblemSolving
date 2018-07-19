package sequences;

public class CountZigZagValues {

    private static int zigzag(int[] a) {
        if(a.length < 2) {
            return a.length;
        }

        int maxSeqLength = 1;
        int curSeqLength = 1;

        for(int i=0;i<a.length;i++) {
            if(isValid(a,i)) {
                curSeqLength ++;
                if(curSeqLength > maxSeqLength) {
                    maxSeqLength = curSeqLength;
                }
            } else {
                curSeqLength = 1;
            }
        }

        return maxSeqLength;
    }

    private static boolean isValid(int[] a, int pos) {
        if(pos-1 < 0) {
            if(a[pos+1] != a[pos] ) {
                return true;
            } else {
                return false;
            }
        } else if(pos+1 >= a.length) {
            if(a[pos-1] != a[pos]) {
                return true;
            } else {
                return false;
            }
        }

        int val = a[pos];
        int left = a[pos-1];
        int right = a[pos+1];

        if((left < val && right < val )|| (left > val && right > val)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4};
        System.out.println(zigzag(arr));
    }
}
