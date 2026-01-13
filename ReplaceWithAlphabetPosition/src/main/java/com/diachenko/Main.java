package com.diachenko;


/*  Default (Template) Project
    13.01.2026
    @author DiachenkoDanylo
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(alphabetPosition("The sunset sets at twelve o' clock."));
        System.out.println("Equals : " + alphabetPosition("The sunset sets at twelve o' clock.").equals("20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11"));
    }

    static String alphabetPosition(String text) {
        final String ALPHABET_LOW = "abcdefghijklmnopqrstuvwxyz";

        text = text.toLowerCase();
        text = text.replace("a-z", " ");
        text = text.trim();
        char[] arr = text.toCharArray();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (i != 1) {
                result.append(" ");
            }
            result.append(ALPHABET_LOW.indexOf(arr[i - 1]) + 1);
        }
        return result.toString();
    }
}