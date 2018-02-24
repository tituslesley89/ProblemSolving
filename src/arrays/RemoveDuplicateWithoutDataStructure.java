package arrays;

public class RemoveDuplicateWithoutDataStructure {

    public static String removeDuplicates(String str) {
        if(str == null || str.length() == 1)
            return str;
        int checker = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if (!((checker & (1 << val)) > 0)) {
                checker |= (1 << val);
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aabbaaabbbaaww"));
    }
}
