package com.diachenko;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*  Default (Template) Project
    09.02.2026
    @author DiachenkoDanylo
*/
public class Main {
//
//    f = new Integer[] {100, 106, 150, 140};
//    r = new Integer[] {100, 110, 65, 120};
//    m1 = new Integer[] {150, 112, 65, 120};
//    m2 = new Integer[] {120, 448, 150, 65};

    public final static double G = 6.674 * Math.pow(10, -11);
    public static Map<String, String> variables = new HashMap<>();
    static Integer[] f = new Integer[]{null, null, null, 106, 150, 140, 100};
    static Integer[] r = new Integer[]{null, null, 100, null, 65, 120, 200};
    static Integer[] m1 = new Integer[]{null, null, 150, 112, null, 120, 150};
    static Integer[] m2 = new Integer[]{null, null, 120, 448, 150, null, 300};

    //    static Integer[] f = {null, null, null, null};
//    static Integer[] r = {null, null, null, null};
//    static Integer[] m1 = {null, null, null, null};
//    static Integer[] m2 = {null, null, null, null};
    //    double[] actual = Kata.newton(f, r, m1, m2);
    double[] expected = new double[]{
            1.20132E-10,
            1.7774123230240458E-4,
            6.330536409949056E13,
            2.5172310458495656E14};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(newton(f, r, m1, m2)));

    }

    public static double[] newton(Integer[] forces, Integer[] radius, Integer[] mass1, Integer[] mass2) {
        Integer[] val;
        double[] result = new double[forces.length];
        for (int i = 0; i < forces.length; i++) {
            val = new Integer[]{forces[i], radius[i], mass1[i], mass2[i], 4};
            val[4] = extracted(val);
            if (val[4] != -1) {
                result[i] = eachVariable(val);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private static int extracted(Integer[] val) {
        int nullable = 0;
        int res = 0;
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            if (val[i] == null) {
                if (nullable != -1) {
                    res = i;
                    nullable = -1;
                } else {
                    return -1;
                }
                found = true;
            }
        }
        return  found ? res : 4;
    }

    public static double eachVariable(Integer[] values) {
        if (values[4] == 0) {
            return G * (values[2] * values[3]) / (values[1] * values[1]);
        }
        if (values[4] == 1) {
            return Math.sqrt(G * (values[2] * values[3]) / values[0]);
        }
        if (values[4] == 2) {
            return (values[0] * (values[1] * values[1])) / (G * values[3]);
        }
        if (values[4] == 4) {
            return 0;
        }
        return (values[0] * (values[1] * values[1])) / (G * values[2]);
    }


    // Better understanding
    public static double eachVariableExplainable(Integer[] values) {
        System.out.println(Arrays.toString(values));
        double searchingVal = 0;
        for (int i = 0; i < values.length; i++) {
            switch (values[4]) {
                case 0: // force
                    searchingVal = G * (values[2] * values[3]) / (values[1] * values[1]);
                    break;
                case 1:  // radius
                    searchingVal = Math.sqrt(G * (values[2] * values[3]) / values[0]);
                    break;
                case 2: // mass1
                    searchingVal = (values[0] * (values[1] * values[1])) / (G * values[3]);
                    break;
                case 3: // mass2
                    searchingVal = (values[0] * (values[1] * values[1])) / (G * values[2]);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + values[4]);
            }
        }
        return searchingVal;
    }


}