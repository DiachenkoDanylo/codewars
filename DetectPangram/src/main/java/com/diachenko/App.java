package com.diachenko;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(checkHashMap("The quick brown fox jumps over the lazy dog"));
        System.out.println(checkHashSet("The quick brown fox jumps over the lazy dog"));
    }

    public static boolean checkHashMap(String sentence){
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : sentence.toLowerCase().toCharArray()){
            if (Character.isLetter(c)) {
                map.put(c,1);
            }
        }
        return map.values().stream().count() ==26;
    }

    public static boolean checkHashSet(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                set.add(c);
                if (set.size() == 26) return true;
            }
        }
        return set.size() == 26;
    }
}
