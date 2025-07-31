package com.diachenko;


/*  Default (Template) Project
    31.07.2025
    @author DiachenkoDanylo
*/

//import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
//        If the function is passed a valid PIN string, return true, else return false.
//        Examples (Input --> Output)
//        "1234"   -->  true
//        "12345"  -->  false
//        "a234"   -->  false

        System.out.println(validatePin("HELLO"));  // false
        System.out.println(validatePin("1234"));   // true
        System.out.println(validatePin("12345"));  // false
        System.out.println(validatePin("123456")); // true
        System.out.println(validatePin("12345a")); // false

    }

    public static boolean validatePin(String pin) {
        return pin.matches("(^\\d{4}$|^\\d{6}$)"); // only 0-9 in group of 4 or 6 , ^ - start of string , $ - end of string
    }

}