package strings;

public class ReverseCStyleString {

    public static String reverseString(char[] s) {
        if(s == null || s.length < 3 ) {
            return new String(s);
        }

        char temp;
        int i = 0, j = s.length-2;
        do {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }while(i<j || i!=j);
        return new String(s);
    }

    public static void main(String[] args) {
        String testWord = "bohemian rhapsody\0";
        char[] chars = testWord.toCharArray();
        System.out.println(chars);
        System.out.println(reverseString(chars));
    }
}
