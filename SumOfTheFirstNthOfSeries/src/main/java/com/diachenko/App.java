package com.diachenko;

/**
 * Hello world!
 */
public class App {
//
//    Task
//    Your task is to write a function which returns the n-th term of the following series,
//    which is the sum of the first n terms of the sequence (n is the input parameter).
//    Series: 1+(1/4)+(1/7)+(1/10)+(1/13)...etc
//    You will need to figure out the rule of the series to complete this.
//    Rules
//    You need to round the answer to 2 decimal places and return it as String.

    public static void main(String[] args) {
        System.out.println(seriesSum(1)); // 1.00
        System.out.println(seriesSum(2)); // 1.25
        System.out.println(seriesSum(5)); // 1.57
    }

    public static String seriesSum(int n) {
        float res = 0.0f;
        for (int i = 0; i < n; i++) {
            res += 1.0f / (1 + i * 3);
        }
        return String.format("%.2f", res);
    }
}
