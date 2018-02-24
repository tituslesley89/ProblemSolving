package strings;

import util.ConsoleUtil;

import java.util.Arrays;
import java.util.List;

public class StringCompression {

    private static String compressString(String s) {
        if(s.isEmpty() || s.length() == 1) {
            return s;
        }
        if(s.length()<compressCount(s)) {
            return s;
        }

        char c = s.charAt(0);
        int counter = 1;
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != c) {
                sb.append(c).append(counter);
                c = s.charAt(i);
                counter = 1;
            } else {
                counter++;
            }
        }
        return sb.append(c).append(counter).toString();
    }

    private static int compressCount(String s) {
        char c = s.charAt(0);
        int counter = 1,
                size = 0;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != c) {
                size += 1 + String.valueOf(counter).length();
                c = s.charAt(i);
                counter = 1;
            } else {
                counter ++;
            }
        }
        return size + 1 + String.valueOf(counter).length();
    }

    public static void main(String[] args) {
        List<String> testStrings = Arrays.asList("a","","abc","aabbcc","awwwwwwwwwwwwwsssssssssssssssssxxxxxxxxxxxxxxxxxxxxzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzwwwwwwwww");
        testStrings.stream().forEach(word -> {
            ConsoleUtil.println("Input String:\'"+word+"\'");
            ConsoleUtil.println("Output:\'"+compressString(word)+"\'");
        });
    }
}
