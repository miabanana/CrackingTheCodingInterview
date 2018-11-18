package main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by huaying on 2018/11/6.
 */
public class _1_2_CheckPermutation {

    public static void main(String[] args) {
        String a1 = "abbc";
        String a2 = "abbc";
        System.out.println(checkPermutation(a1, a2));

        String b1 = "abbc";
        String b2 = "bcab";
        System.out.println(checkPermutation(b1, b2));

        String c1 = "abbc";
        String c2 = "efgb";
        System.out.println(checkPermutation(c1, c2));
    }

    private static boolean checkPermutation(String a, String b) {
        if (a.equals(b)) return false;

        if (a.length() != b.length()) return false;

//        Map<Character, Integer> mapA = getMap(a.toCharArray());
//        Map<Character, Integer> mapB = getMap(b.toCharArray());

        Map<Character, Integer> mapA = getTable(a.toCharArray());
        Map<Character, Integer> mapB = getTable(b.toCharArray());

        return mapA.equals(mapB);
    }

    private static Map<Character, Integer> getMap(char[] charArray) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map.toString());
        return map;
    }

    private static Map<Character, Integer> getTable(char[] charArray) {
        Map<Character, Integer> map = new Hashtable<>();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map.toString());
        return map;
    }
}
