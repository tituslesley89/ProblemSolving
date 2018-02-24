package util;

import java.util.Random;

public class RandomUtil {

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumber() {
        return getRandomNumber(0,100);
    }
}
