package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelephoneWord {

    private static List<Character> getCharactersForNumber(int num) {
        switch (num) {
            case 1 : return Arrays.asList('1');
            case 2 : return Arrays.asList('A','B','C');
            case 3 : return Arrays.asList('D','E','F');
            case 4 : return Arrays.asList('G','H','I');
            case 5 : return Arrays.asList('J','K','L');
            case 6 : return Arrays.asList('M','N','O');
            case 7 : return Arrays.asList('P','Q','R','S');
            case 8 : return Arrays.asList('T','U','V');
            case 9 : return Arrays.asList('W','X','Y','Z');
            default: return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

    }
}
