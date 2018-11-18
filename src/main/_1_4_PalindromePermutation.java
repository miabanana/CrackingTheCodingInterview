package main;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by huaying on 2018/11/13.
 */
public class _1_4_PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcbc"));
        System.out.println(isPalindrome("abcbcd"));
        System.out.println(isPalindrome("abcbca"));

        System.out.println(isPalindrome2("abcbc"));
        System.out.println(isPalindrome2("abcbcd"));
        System.out.println(isPalindrome2("abcbca"));
    }

    public static boolean isPalindrome(String string) {
        boolean isEven = string.length()%2 == 0;
        int oddCounts = 0;

        char[] chars = string.toCharArray();

        Map<Character, Integer> map = new Hashtable<>();
        for (int i = 0; i<string.length(); i++) {
            if (map.containsKey(chars[i])) {
                int value = map.get(chars[i]);
                map.put(chars[i], value+1);

                if (value %2 == 0) {
                    oddCounts++;
                } else {
                    oddCounts--;
                }

            } else {
                map.put(chars[i], 1);
                oddCounts++;
            }
        }

        if (isEven && oddCounts == 0) return true;
        else if (!isEven && oddCounts == 1) return true;
        else return false;
    }


    private static boolean isPalindrome2(String string) {
        int[] table = stringToTable(string);

        boolean hasOdd = false;

        for (int i : table) {
            if (i % 2 == 1) {
                if (hasOdd) {
                    return false;
                }

                hasOdd = true;
            }
        }

        return true;
    }

    private static int getCharValue(char c) {
        int low = Character.getNumericValue('a');
        int high = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);
        if (low <= value && value <= high) {
            return value - low;
        } else {
            return -1;
        }
    }

    private static int[] stringToTable(String string) {
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];

        for (char c : string.toCharArray()) {
            int position = getCharValue(c);
            if (position != -1) {
                table[position] ++;
            }
        }

        return table;
    }
}
