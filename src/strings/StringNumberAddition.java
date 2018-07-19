package strings;

import util.ConsoleUtil;

public class StringNumberAddition {

    public static String addTwoStringNumbers(String a, String b) {
        if(a.isEmpty()) {
            if(b.isEmpty()) {
                return a;
            }else {
                return b;
            }
        } else {
            if(b.isEmpty()) {
                return a;
            }
        }

        String tempA = new StringBuilder(a).reverse().toString();
        String tempB = new StringBuilder(b).reverse().toString();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(tempA.length(), tempB.length());

        for(int i=0;i<maxLength;i++) {
            int valAtA = i >= tempA.length() ? 0 : charToInt(tempA.charAt(i));
            int valAtB = i >= tempB.length() ? 0 : charToInt(tempB.charAt(i));
            int currentSum = valAtA + valAtB + carry;
            carry = currentSum / 10;
            result.append(currentSum%10);
        }

        if(carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static int charToInt(char c) {
        switch(c) {
            case '1' : return 1;
            case '2' : return 2;
            case '3' : return 3;
            case '4' : return 4;
            case '5' : return 5;
            case '6' : return 6;
            case '7' : return 7;
            case '8' : return 8;
            case '9' : return 9;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String a = "12129388147124";
        String b = "209359021409124";

        ConsoleUtil.println(addTwoStringNumbers(a,b));
    }
}
