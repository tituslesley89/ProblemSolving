package strings;

import util.ConsoleUtil;

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

    private static void telephoneWordHelper(String word, String remNum) {
        if(remNum.isEmpty()) {
            ConsoleUtil.println(word);
            return;
        }

        int curNum = Integer.parseInt(remNum.charAt(0)+"");
        List<Character> listOfCharacters = getCharactersForNumber(curNum);

        listOfCharacters.forEach(chr -> {
            String newWord = word + chr;
            String newRemNumber = remNum.substring(1,remNum.length());
            telephoneWordHelper(newWord, newRemNumber);
        });
    }

    private static void telephoneNumber(String s) {
        telephoneWordHelper("",s);
    }

    public static void main(String[] args) {
        String number = "4971927";
        telephoneNumber(number);
    }
}
