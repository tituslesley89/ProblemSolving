package strings;

import util.ConsoleUtil;

public class RecursiveStringPermutation {

    private static void permutateStringHelper(String picked, String notPicked) {
        if(notPicked.isEmpty()) {
            ConsoleUtil.println(picked);
            return;
        }

        for(int i=0;i<notPicked.length();i++) {
            String newPicked = picked + notPicked.charAt(i);
            String newNotPicked = notPicked.substring(0,i) + notPicked.substring(i+1,notPicked.length());
            permutateStringHelper(newPicked, newNotPicked);
        }

    }
    private static void permutateString(String s) {
        permutateStringHelper("",s);
    }

    public static void main(String[] args) {
        String s = "abc";
        permutateString(s);
    }
}
