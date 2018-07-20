package strings;

import util.ConsoleUtil;

public class StringNumberMultiplication {

    public static String multiplyTwoStrings(String a, String b) {

        boolean isASmallest = a.length() < b.length();
        String tempA, tempB;
        if(isASmallest) {
            tempA = new String(a);
            tempB = new String(b);
        } else {
            tempA = new String(b);
            tempB = new String(a);
        }
        String result = new String("0");

        for(int i=tempA.length()-1;i>=0;i--) {
            int valA = StringNumberAddition.charToInt(tempA.charAt(i));
            int carry = 0;
            StringBuilder currentReesult = new StringBuilder();
            for(int j=0;j<i;j++) {
                currentReesult.append(0);
            }
            for(int j=tempB.length()-1;j>=0;j++) {
                int valB = StringNumberAddition.charToInt(tempB.charAt(j));

                int independentResult = valA * (valB + carry);
                carry = independentResult % 10;
                currentReesult.append(carry/10);
            }
            if(carry > 0) {
                currentReesult.append(carry * valA);
            }
            result = StringNumberAddition.addTwoStringNumbers(result, currentReesult.reverse().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "5";
        String b = "10";

        ConsoleUtil.println(multiplyTwoStrings(a,b));
    }
}
