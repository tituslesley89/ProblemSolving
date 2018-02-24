package mains;

import sequences.IterativeFibonacciSequence;
import sequences.RecursiveFibonacciSequence;

public class FibonacciSequenceMain {

    public static void main(String[] args) {
        System.out.println(RecursiveFibonacciSequence.getFibonacciSequence(12));
        System.out.println(IterativeFibonacciSequence.getFibonacciSequence(9));
    }
}
