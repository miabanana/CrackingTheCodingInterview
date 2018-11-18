package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huaying on 2018/8/19.
 */
public class _1_1_IsUnique {

    public static void main(String[] args) {
        String a = "abcde";
        System.out.println(a + "? " + isAllUniqueBySet(a));
        System.out.println(a + "? " + isAllUniqueByForLoop(a));

        String b = "abccde";
        System.out.println(b + "? " + isAllUniqueBySet(b));
        System.out.println(b + "? " + isAllUniqueByForLoop(b));

        String c = "abb";
        System.out.println(c + "? " + isAllUniqueBySet(c));
        System.out.println(c + "? " + isAllUniqueByForLoop(c));
    }

    private static boolean isAllUniqueBySet(String string) {
        if (string.length() > 26) return false;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if (set.contains(string.charAt(i))) {
                return false;
            }

            set.add(string.charAt(i));
        }

        return true;
    }

    private static boolean isAllUniqueByForLoop(String string) {
        if (string.length() > 26) return false;

        char[] array = string.toCharArray();
        Arrays.sort(array);

        for (int i = 0; i < string.length()-1; i++) {
            if (array[i] == array[i+1]) {
                return false;
            }
        }

        return true;
    }
}
