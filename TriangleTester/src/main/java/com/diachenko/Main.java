package com.diachenko;


/*  Default (Template) Project
    02.08.2025
    @author DiachenkoDanylo
*/


public class Main {
    public static void main(String[] args) {
//
//        Implement a function that accepts 3 integer values a, b, c.
//        The function should return true if a triangle can be built with the sides of given length and false in any other case.
//        (In this case, all triangles must have surface greater than 0 to be accepted).
//        Examples:
//        Input -> Output
//        1,2,2 -> true
//        4,2,3 -> true
//        2,2,2 -> true
//        1,2,3 -> false
//       -5,1,3 -> false
//        0,2,3 -> false
//        1,2,9 -> false
        // Triangle can be build only if the sum of any 2 sides bigger than other side
        // ex:  AB + BC > CA
        System.out.println(isTriangle(1, 2, 2)); // true
        System.out.println(isTriangle(4, 2, 3)); // true
        System.out.println(isTriangle(1, 2, 9)); // false

    }

    public static boolean isTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && c + b > a;
    }
}