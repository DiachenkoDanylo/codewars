package com.diachenko;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBy(2, 5)));
    }

    public static int[] countBy(int x, int n){
        int[] res = new int[n];
        for (int i = 1; i<=n; i++) {
            res[i-1] = x*i;
        }
        return res;
    }
}
