package sequences;

public class IterativeFibonacciSequence {

    public static int getFibonacciSequence(int n) {
        int fib1 = 1;
        int fib2 = 1;

        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }

        int temp = fib2;
        for(int i=2;i<n;i++) {
            fib2 = fib1 + fib2;
            fib1 = temp;
            temp = fib2;
        }

        return fib2;
    }
}
