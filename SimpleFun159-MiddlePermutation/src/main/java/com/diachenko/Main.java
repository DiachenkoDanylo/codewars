package com.diachenko;


/*  Default (Template) Project
    04.08.2025
    @author DiachenkoDanylo
*/

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Task
//        You are given a string s. Every letter in s appears once.
//
//        Consider all strings formed by rearranging the letters in s. After ordering these strings in dictionary order, return the middle term. (If the sequence has a even length n, define its middle term to be the (n/2)th term.)
//
//        Example
//        For s = "abc", the result should be "bac".
//
//                The permutations in order are: "abc", "acb", "bac", "bca", "cab", "cba" So, The middle term is "bac".
//
//                Input/Output
//                [input] string s
//        unique letters (2 <= length <= 26)
//
//                [output] a string
//        middle permutation.

        calculateTimeForMethod(("asdfgh"), true);                   // 2 milisec
        calculateTimeForMethod(("asdfgh"), false);                  // 34 milisec
        calculateTimeForMethod(("zasxdcfvgbhnj"), true);            // 1 milisec
        calculateTimeForMethod(("zasxdcfgh"), false);               // 860 milisec
        calculateTimeForMethod(("qwertyuioasdfghjkzxcvbnm"), true); // 1 milisec
    }

    public static void calculateTimeForMethod(String str, boolean isOptimized) {
        long start = System.currentTimeMillis();
        if (isOptimized) {
            System.out.println(findMidPermOptimized(str));
            System.out.println("Time taken for optimized test is: " + (System.currentTimeMillis() - start));
        } else {
            System.out.println(findMidPerm(str));
            System.out.println("Time taken for NON optimized test is: " + (System.currentTimeMillis() - start));
        }
    }

    // Solution #1
    // Algorhitmic Time Complexity O(n^2)

    public static String findMidPermOptimized(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        BigInteger totalPerms = factorialHavingLargeResult(chars.length);
        BigInteger midIndex = totalPerms.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));

        return getNthPermutation(chars, midIndex);
    }

    public static BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    private static String getNthPermutation(char[] chars, BigInteger index) {
        List<Character> available = new ArrayList<>();
        for (char c : chars) available.add(c);

        StringBuilder result = new StringBuilder();
        BigInteger fact = factorialHavingLargeResult(available.size());

        while (!available.isEmpty()) {
            fact = fact.divide(BigInteger.valueOf(available.size()));
            int pos = index.divide(fact).intValue();
            result.append(available.remove(pos));
            index = index.mod(fact);
        }

        return result.toString();
    }


    // Solution #2
    // Algorhitmic Time Complexity O(n!)
    // Takes so much time for long strings

    public static String findMidPerm(String str) {
        List<String> list = singlePermutations(str);
        list.sort(Comparator.naturalOrder());
        return list.size() % 2 == 0 ? list.get(list.size() / 2 - 1) : list.get(list.size() / 2);
    }

    //Code from task So Many Permutations

    public static List<String> singlePermutations(String s) {
        Set<String> set = new HashSet<>();
        permute("", s, set);
        return new ArrayList<>(set);
    }

    private static void permute(String prefix, String remaining, Set<String> results) {
        int n = remaining.length();
        if (n == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n),
                        results);
            }
        }
    }
}