package com.diachenko;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(betterThanAverage(new int[]{100, 40, 34, 57, 29, 72, 57, 88}, 75));
        System.out.println(betterThanAverageStream(new int[]{100, 40, 34, 57, 29, 72, 57, 88}, 75));
    }
//    There was a test in your class and you passed it. Congratulations!
//    But you're an ambitious person. You want to know if you're better than the average student in your class.
//    You receive an array with your peers' test scores. Now calculate the average and compare your score!
//    Return true if you're better, else false!
//    Note:
//    Your points are not included in the array of your class's points. Do not forget them when calculating the average score!

    public static boolean betterThanAverageStream(int[] classPoints, int yourPoints) {
        return Arrays.stream(classPoints).average().getAsDouble() < yourPoints;
    }

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        int sum =0;
        for (int classPoint : classPoints) {
            sum += classPoint;
        }
        return  sum/classPoints.length < yourPoints;
    }
}
