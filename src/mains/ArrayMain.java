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
            ConsoleUtil.print("Unsorted array:");
            ConsoleUtil.printArray(arr);
            ConsoleUtil.newline();
            ConsoleUtil.print("Sorted Array:");
            ConsoleUtil.printArray(sortingAlgo.apply(arr));
            ConsoleUtil.newline();
            ConsoleUtil.newline();
        });
    }

    public static void ArraysToInt(Function<List<Integer>, Integer> arryToIntAlgo) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(false);

        ConsoleUtil.println("Running function: " + arryToIntAlgo.getClass().getName());
        inputArrays.stream().forEach(arr -> {
            ConsoleUtil.print("Array:");
            ConsoleUtil.printArray(arr);
            ConsoleUtil.newline();
            ConsoleUtil.print("Result:"+arryToIntAlgo.apply(arr));
            ConsoleUtil.newline();
            ConsoleUtil.newline();
        });
    }

    public static void ArraysToVoid(Consumer<List<Integer>> consumer) {
        List<List<Integer>> inputArrays = ArrayUtil.generateListOfRandomArrays(false);

        ConsoleUtil.println("Running function: " + consumer.getClass().getName());
        inputArrays.stream().forEach(arr -> {
            ConsoleUtil.print("Array:");
            ConsoleUtil.printArray(arr);
            ConsoleUtil.newline();
            consumer.accept(arr);
            ConsoleUtil.newline();
            ConsoleUtil.newline();
        });
    }
}
