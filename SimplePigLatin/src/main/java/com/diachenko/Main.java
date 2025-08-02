package com.diachenko;


/*  Default (Template) Project
    02.08.2025
    @author DiachenkoDanylo
*/

public class Main {
    public static void main(String[] args) {
//        Move the first letter of each word to the end of it, then add "ay" to the end of the word.
//        Leave punctuation marks untouched.

//        Examples
//        pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
//        pigIt('Hello world !');     // elloHay orldway !

        System.out.println(pigIt("Hello world !"));    // elloHay orldway !
        System.out.println(pigIt("Pig latin is cool"));// igPay atinlay siay oolcay
        System.out.println(pigIt("Codewars simple pig ?!")); // odewarsCay implesay igpay ?!
    }

    public static String pigIt(String str) {
        String[] arr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (!Character.isLetter(word.charAt(0))) {
                stringBuilder.append(word); // just add punctuation
            } else {
                char firstChar = word.charAt(0);
                stringBuilder.append(word.substring(1)).append(firstChar).append("ay");
            }
            if (i != arr.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}