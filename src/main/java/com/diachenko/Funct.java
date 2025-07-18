package com.diachenko;
/*  codewars
    18.03.2025
    @author DiachenkoDanylo
*/

import java.util.HashMap;

public class Funct {
    public static int duplicateCount(String text) {
        String text2 = text.toLowerCase();
        HashMap<Character, Integer> val = new HashMap<>();
        for (int i = 0; i < text2.length(); i++) {
            char k = text2.charAt(i);
            if (!val.containsKey(k)) {
                val.put(k, 1);
            } else {
                val.compute(k, (key, o) -> o + 1);
            }
        }
        return (int) val.values().stream()
                .filter(value -> value.intValue() >= 2).count();
    }
}
