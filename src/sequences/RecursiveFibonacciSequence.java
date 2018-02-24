package sequences;

public class RecursiveFibonacciSequence {

    public static int getFibonacciSequence(int n) {
        if(n == 0) {
            return 0;
        }
        if(n==1 || n==2) {
            return 1;
        }
        return getFibonacciSequence(n-1) + getFibonacciSequence(n-2);
    }
}
