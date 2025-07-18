package com.diachenko;


/*  Default (Template) Project
    18.07.2025
    @author DiachenkoDanylo
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}; // res = WEST

        System.out.println(Arrays.toString(dirReduc(arr)));
    }

    public static String[] dirReduc(String[] arr) {
        String[] res = arr.clone();
        while (hasReduc(res)) {
            String[] temp = new String[res.length];
            int k = 0;
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1 && (isMatch(res[i], res[i + 1]))) {
                    i++;
                } else {
                    temp[k++] = res[i];
                }
            }
            res = Arrays.stream(temp)
                    .filter(s -> s != null && !s.isEmpty())
                    .toArray(String[]::new);
        }
        return res;
    }

    public static boolean hasReduc(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (isMatch(arr[i], arr[i + 1])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatch(String a, String b) {
        return ((a.equals("NORTH") && b.equals("SOUTH"))
                || (a.equals("SOUTH") && b.equals("NORTH"))
                || (a.equals("EAST") && b.equals("WEST"))
                || (a.equals("WEST") && b.equals("EAST")));
    }
}