package com.diachenko;


/*  Default (Template) Project
    23.12.2025
    @author DiachenkoDanylo
*/

public class Main {

//    'world'  =>  'dlrow'
//    'word'   =>  'drow'

    private static final int ITERATIONS = 50_000;
    public static String loren = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
    public static String reversed = "murobal tse di mina tillom tnuresed aiciffo iuq apluc ni tnus ,tnediorp non tatadipuc taceacco tnis ruetpecxE .rutairap allun taiguf ue erolod mullic esse tilev etatpulov ni tiredneherper ni rolod eruri etua siuD .tauqesnoc odommoc ae xe piuqila tu isin sirobal ocmallu noitaticrexe durtson siuq ,mainev minim da mine tU .auqila angam erolod te erobal tu tnudidicni ropmet domsuie od des ,tile gnicsipida rutetcesnoc ,tema tis rolod muspi meroL";

    public static void main(String[] args) {
        // 1️⃣ перевірка правильності
        validate();

        // 2️⃣ бенчмарк
        String str = "abcdefghijklmnopqrstuvwxyz".repeat(100);
        warmUp(str);

        benchmark("solution1", () -> solution1(str));
        benchmark("solution2", () -> solution2(str));
        benchmark("solution3", () -> solution3(str));
        benchmark("solution4", () -> solution4(str));
    }

    static void validate() {
        check("solution1", solution1(loren));
        check("solution2", solution2(loren));
        check("solution3", solution3(loren));
        check("solution4", solution4(loren));

        System.out.println("✔ All solutions are correct\n");
    }

    static void check(String name, String result) {
        if (!reversed.equals(result)) {
            throw new IllegalStateException(name + " FAILED!");
        }
    }

    static void warmUp(String str) {
        for (int i = 0; i < 10_000; i++) {
            solution1(str);
            solution2(str);
            solution3(str);
            solution4(str);
        }
    }

    static void benchmark(String name, Runnable task) {
        long start = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            task.run();
        }

        long time = System.nanoTime() - start;
        System.out.println(name + ": " + time / 1_000_000 + " ms");
    }

    //    #1 SLOWEST
    public static String solution1(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = str.length(); i >= 1; i--) {
            result.append(str.charAt(i - 1));
        }
        return result.toString();
    }


    //    #2
    public static String solution2(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[result.length - 1 - i] = chars[i];
        }
        return new String(result);
    }

    //    #3
    public static String solution3(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char cur = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = cur;
        }
        return new String(chars);
    }

    //    #4  FASTEST
    public static String solution4(String str) {
        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString();
    }
}