package util;

import java.util.Stack;
import java.util.stream.IntStream;

public class StackUtil {

    public static Stack<Integer> getRandomStack() {
        int stackSize = RandomUtil.getRandomNumber(0, 10);
        Stack<Integer> s = new Stack<>();

        IntStream.range(0, stackSize).forEach(i -> {
            s.push(RandomUtil.getRandomNumber());
        });
        return s;
    }

    public static void printStack(Stack<Integer> s) {
        ConsoleUtil.print("{");
        s.stream().forEach(v -> {
            ConsoleUtil.print(v+", ");
        });
        ConsoleUtil.print("}");
    }
}
