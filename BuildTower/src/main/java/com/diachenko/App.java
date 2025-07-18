package com.diachenko;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    /*
        Build Tower
        Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors. A tower block is represented with "*" character.
        For example, a tower with 3 floors looks like this:
        [
          "  *  ",
          " *** ",
          "*****"
        ]
    */

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Arrays.toString(towerBuilder(3)));
    }

    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            int spaces = nFloors - i - 1;
            int stars = i * 2 + 1;

            String floor = " ".repeat(spaces) + "*".repeat(stars) + " ".repeat(spaces);
            tower[i] = floor;
        }
        return tower;
    }
}
