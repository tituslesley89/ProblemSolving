package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayUtil {

    public static List<Integer> generateRandomArray(int minSize, int maxSize) {
        List<Integer> generatedArray = new ArrayList<>();

        IntStream.range(0, RandomUtil.getRandomNumber(minSize,maxSize)).forEach(i -> {
            generatedArray.add(RandomUtil.getRandomNumber());
        });
        return generatedArray;
    }

    public static List<Integer> generateRandomArray() {
        return generateRandomArray(3,6);
    }

    public static List<List<Integer>> generateListOfRandomArrays() {
        List<List<Integer>> listOfRandomArrays = new ArrayList<>();

        IntStream.range(0,10).forEach(i -> {
            listOfRandomArrays.add(generateRandomArray());
        });
        return listOfRandomArrays;
    }

}
