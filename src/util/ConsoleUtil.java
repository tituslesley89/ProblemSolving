package util;

import java.util.List;

public class ConsoleUtil {

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void newline() {
        System.out.println();
    }

    public static void printArray(List<Integer> arr) {
        print("{");
        arr.stream().forEach(i->{
            print(i+",");
        });
        print("}");
    }
}
