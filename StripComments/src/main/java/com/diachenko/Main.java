package com.diachenko;


/*  codewars
    14.01.2026
    @author DiachenkoDanylo
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));
        System.out.println("apples, pears\ngrapes\nbananas");
        System.out.println(stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"}));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] arr = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            int minLength = getMinLength(commentSymbols, s);
            if (minLength > -1) {
                String res = s.substring(0, minLength);
                res = res.isEmpty() ? res : s.substring(0, minLength).stripTrailing();
                sb.append(res);
            } else {
                sb.append(s.stripTrailing());
            }
            if (i + 1 < arr.length) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static int getMinLength(String[] commentSymbols, String s) {
        int minLength = s.length();
        for (String symbol : commentSymbols) {
            int index = s.indexOf(symbol);
            if (index > -1 && index < minLength) {
                minLength = index;
            }
        }
        return minLength;
    }
}
