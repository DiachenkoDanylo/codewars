package com.diachenko;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int[] val =  new int[]{4,6,2,1,9,63,-134,566};

        int max = max(val);
        int min = min(val);

        System.out.println(String.format("Max : %s Min : %s",max, min));

        max= maxStream(val);
        min = minStream(val);
        System.out.println(String.format("Max : %s Min : %s",max, min));
    }

    public static int min(int[] list) {
        int minVal = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i]< minVal){
                minVal= list[i];
            }
        }
        return minVal;
    }

    public static int max(int[] list) {
        int maxVal = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i]> maxVal){
                maxVal= list[i];
            }
        }
        return maxVal;
    }

    public static int minStream(int[] list) {
        return Arrays.stream(list).min().getAsInt();
    }

    public static int maxStream(int[] list) {
        return Arrays.stream(list).max().getAsInt();
    }
}
