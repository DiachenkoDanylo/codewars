package com.diachenko;


/*  Default (Template) Project
    02.02.2026
    @author DiachenkoDanylo
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testing();
    }

    //1 Too complex, fragile
    static String toCamelCase(String s) {
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int prevInd = 0;
        int nextInd = Math.min(s.indexOf('-', prevInd), s.indexOf('_', prevInd));
        while (s.indexOf('-', prevInd) != -1 || s.indexOf('_', prevInd) != -1) {
            int a = s.indexOf('-', prevInd);
            int b = s.indexOf('_', prevInd);
            nextInd = (a == -1) || (b == -1) ? Math.max(a, b) + 1 : Math.min(a, b) + 1;
            res.append(s, prevInd, nextInd - 1);
            res.append(Character.toUpperCase(s.charAt(nextInd)));
            if (nextInd + 2 < s.length()) {
                prevInd = nextInd + 1;
            }
        }
        res.append(s, nextInd + 1, s.length());
        return res.toString();
    }

    // 2 BEST
    static String toCamelCaseSplit(String s) {
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        String[] words = s.split("[-_]");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                res.append(i == 0 ? words[i].charAt(0) : Character.toUpperCase(words[i].charAt(0)))
                        .append(words[i].substring(1));
            }
        }
        return res.toString();
    }

    // 3 Overkill
    static String toCamelCaseArr(String s) {
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean isLastChar = true;
        for (char aChar : chars) {
            if (!isLastChar && (aChar != '-' && aChar != '_')) {
                res.append(Character.toUpperCase(aChar));
                isLastChar = true;
            } else {
                if (aChar == '-' || aChar == '_') {
                    isLastChar = false;
                } else {
                    res.append(aChar);
                }
            }
        }
        return res.toString();
    }

    // 4 Stream
    static String toCamelCaseStream(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    static void testing() {
        System.out.println("Method ---- 1");
        System.out.println(toCamelCase("the-stealth-warrior-x3d"));
        System.out.println(toCamelCase("The-Stealth_Warrior-war_steal"));
//        System.out.println(toCamelCase("--e-Edge-CaS-e")); NOT HANDLE
        System.out.println("Method ---- 2");
        System.out.println(toCamelCaseSplit("the-stealth-warrior-x3d"));
        System.out.println(toCamelCaseSplit("The-Stealth_Warrior-war_steal"));
        System.out.println(toCamelCaseSplit("--e-Edge-CaS-e"));
        System.out.println("Method ---- 3");
        System.out.println(toCamelCaseArr("the-stealth-warrior-x3d"));
        System.out.println(toCamelCaseArr("The-Stealth_Warrior-war_steal"));
        System.out.println(toCamelCaseArr("--e-Edge-CaS-e"));
        System.out.println("Method ---- 4");
        System.out.println(toCamelCaseStream("the-stealth-warrior-x3d"));
        System.out.println(toCamelCaseStream("The-Stealth_Warrior-war_steal"));
//        System.out.println(toCamelCaseStream("--e-Edge-CaS-e"));  NOT HANDLE

        System.out.println("Method ---- 1 nullable");
        System.out.println(toCamelCase(""));
        System.out.println("Method ---- 2 nullable");
        System.out.println(toCamelCaseSplit(""));
        System.out.println("Method ---- 3 nullable");
        System.out.println(toCamelCaseArr(""));
        System.out.println("Method ---- 4 nullable");
        System.out.println(toCamelCaseStream(""));
    }
}