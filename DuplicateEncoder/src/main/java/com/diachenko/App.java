package com.diachenko;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(encode("rEcede"));
    }

    static String encode(String word) {
        String lowerCase = word.toLowerCase();
        HashMap<Character, Integer> val = new HashMap<>();
        for (int i = 0; i < lowerCase.length(); i++) {
            if (val.containsKey(lowerCase.charAt(i))) {
                val.compute(lowerCase.charAt(i), (key, o) -> o + 1);
            } else {
                val.put(lowerCase.charAt(i), 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lowerCase.length(); i++) {
            builder.append(val.get(lowerCase.charAt(i)) >= 2 ? ')' : '(');
        }
        return builder.toString();
    }
}
