package com.diachenko;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    /*
    Task
    You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.

    Examples
    [7, 1]  =>  [1, 7]
    [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
    [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
    */
    public static void main(String[] args) {
        int[] abc = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(sortArray(abc)));
    }

    public static int[] sortArray(int[] array) {
        int[] oddNumbers = Arrays.stream(array)
                .filter(n -> n % 2 != 0)
                .sorted()
                .toArray();

        int oddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = oddNumbers[oddIndex++];
            }
        }
        return array;
    }
}
