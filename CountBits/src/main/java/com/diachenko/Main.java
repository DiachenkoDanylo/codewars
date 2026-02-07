package com.diachenko;


/*  Default (Template) Project
    03.02.2026
    @author DiachenkoDanylo
*/

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        int num = 1234;
        String binary = Integer.toBinaryString(num);
        System.out.println(binary);
        System.out.println(countBits(num));
        System.out.println(countBits2(num));
    }

    public static int countBits(int n) {
        String binary = Integer.toBinaryString(n);
        int val = 0;
        for (String a : binary.split("")) {
            val += Integer.parseInt(a);
        }
        return val;
    }

    public static int countBits2(int n) {
        return Stream.of(Integer.toBinaryString(n).split("")).mapToInt(Integer::parseInt).sum();
    }

}