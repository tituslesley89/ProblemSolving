package strings;

import util.ConsoleUtil;

public class StringCombination {

    private static void combinateStringHelper(String picked, String notPicked) {
        ConsoleUtil.println(picked);
        if(notPicked.isEmpty()) {
            return;
        }

        for(int i=0;i<notPicked.length();i++) {
            String newPicked = picked + notPicked.charAt(i);
            String newNotPicked = notPicked.substring(i+1,notPicked.length());
            combinateStringHelper(newPicked, newNotPicked);
        }


    }
    private static void combinateString(String s) {
        combinateStringHelper("",s);
    }

    public static void main(String[] args) {
        String s = "abc";
        combinateString(s);
    }
}
