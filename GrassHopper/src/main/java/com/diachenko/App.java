package com.diachenko;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(getGrade(99,22,55));
        System.out.println(getGrade(40,22,40));
        System.out.println(getGrade(99,91,85));

    }

    public static char getGrade(int s1, int s2, int s3) {
        int avg = (s1+s2+s3) /3;
        if (avg < 60){
            return 'F';
        } else if (avg < 70) {
            return 'D';
        } else if (avg < 80) {
            return 'C';
        } else {
            return avg< 90 ? 'B' : 'A';
        }
    }
}
