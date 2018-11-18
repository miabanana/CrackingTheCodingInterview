package main;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by huaying on 2018/11/17.
 */
public class FrequencySort {

    public String frequencySort(String s) {
        if (s == null) throw new NullPointerException();

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new Hashtable<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!map.isEmpty()) {
            char maxChar = getMaxCountChar(map);

            stringBuilder.append(getRepeatedString(maxChar, map.get(maxChar)));

            map.remove(maxChar);
        }

        return stringBuilder.toString();
    }

    private char getMaxCountChar(Map<Character, Integer> map) {
        char c = ' ';
        int max = 0;

        for (Character key : map.keySet()) {
            int value = map.get(key);

            if (max < value) {
                max = value;
                c = key;
            }
        }

        return c;
    }

    private String getRepeatedString(char c, int count) {
        if (count == 1) return String.valueOf(c);

        StringBuilder result = new StringBuilder();

        while(count > 0) {
            result = result.append(c);
            count--;
        }

        return result.toString();
    }
}
