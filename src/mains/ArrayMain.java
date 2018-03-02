package mains;

import util.ArrayUtil;
import util.ConsoleUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ArrayMain {

    public static void runSortingArray(Function<List<Integer>, List<Integer>> sortingAlgo) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(false);

        ConsoleUtil.println("Sorting using: " + sortingAlgo.getClass().getName());
        inputArrays.stream().forEach(arr -> {
            ConsoleUtil.printArrayWithMessage(arr, "Unsorted array:");
            ConsoleUtil.printArrayWithMessage(sortingAlgo.apply(arr), "Sorted Array:");
            ConsoleUtil.newline();
        });
    }

    public static void runSortingArray(Consumer<List<Integer>> sortingAlgo) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(false);

        ConsoleUtil.println("Sorting using: " + sortingAlgo.getClass().getName());
        inputArrays.stream().forEach(arr -> {
            ConsoleUtil.printArrayWithMessage(arr, "Unsorted array:");
            sortingAlgo.accept(arr);
            ConsoleUtil.printArrayWithMessage(arr, "Sorted Array:");
            ConsoleUtil.newline();
        });
    }

    public static void FindSequenceInArray(Consumer<List<Integer>> consumerFunction) {
        FindSequenceHelper(consumerFunction, false);
    }

    public static void FindSequenceInNegativeArray(Consumer<List<Integer>> consumerFunction) {
        FindSequenceHelper(consumerFunction, true);
    }

    public static void  FindSequenceHelper(Consumer<List<Integer>> consumer, boolean hasNegative) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(hasNegative);

        ConsoleUtil.println("Running function: " + consumer.getClass().getName());
        inputArrays.stream().forEach(arr -> {

            ConsoleUtil.print("Array:");
            ConsoleUtil.printArray(arr);
            ConsoleUtil.newline();
            ConsoleUtil.print("Result:");
            consumer.accept(arr);
            ConsoleUtil.newline();
            ConsoleUtil.newline();
        });
    }
}
