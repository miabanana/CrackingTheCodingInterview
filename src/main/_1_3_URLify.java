package main;

/**
 * Created by huaying on 2018/11/13.
 */
public class _1_3_URLify {

    public static void main(String[] args) {
        String s1 = "abc def g    ";
        String s12 = "abc%20def%20g";
        char[] c1 = s1.toCharArray();
        urlify(c1, 9);
        System.out.println(s1 + "->" + String.copyValueOf(c1).equals(s12));
    }

    private static void urlify(char[] chars, int length) {
        int finalLength;
        int whiteSpaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                whiteSpaceCount++;
            }
        }

        finalLength = length + whiteSpaceCount*2;

        if (chars.length > length) {
            //a_bc_ = 5, true len = 4
            chars[length] = '\0';
        }

        for (int i = length-1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[finalLength-1] = '0';
                chars[finalLength-2] = '2';
                chars[finalLength-3] = '%';
                finalLength = finalLength - 3;
            } else {
                chars[finalLength-1] = chars[i];
                finalLength--;
            }
        }
    }
}
