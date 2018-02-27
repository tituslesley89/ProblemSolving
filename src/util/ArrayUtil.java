package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayUtil {

    public static List<Integer> generateRandomArray(int minSize, int maxSize) {
        return generateAnyRandomArray(minSize, maxSize, 0, 100);
    }

    public static List<Integer> generateRandomNegativeArray(int minSize, int maxSize) {
        return generateAnyRandomArray(minSize, maxSize, -50,50);
    }

    public static List<Integer> generateAnyRandomArray(int minSize, int maxSize, int minValue, int maxValue) {
        List<Integer> generatedArray = new ArrayList<>();

        IntStream.range(0, RandomUtil.getRandomNumber(minSize,maxSize)).forEach(i -> {
            generatedArray.add(RandomUtil.getRandomNumber(minValue,maxValue));
        });
        return generatedArray;
    }

    public static List<List<Integer>> generateListOfRandomArrays(boolean hasNegative) {
        List<List<Integer>> listOfRandomArrays = new ArrayList<>();

        IntStream.range(0,10).forEach(i -> {
            List<Integer> arr;
            if(hasNegative) {
                arr = generateRandomNegativeArray(3, 6);
            } else {
                arr = generateRandomArray(3, 6);
            }
            listOfRandomArrays.add(arr);
        });
        return listOfRandomArrays;
    }

}
