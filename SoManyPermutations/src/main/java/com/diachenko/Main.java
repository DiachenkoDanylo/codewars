package com.diachenko;


/*  Default (Template) Project
    19.07.2025
    @author DiachenkoDanylo
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        With input 'a':
//        Your function should return: ['a']
//
//        With input 'ab':
//        Your function should return ['ab', 'ba']
//
//        With input 'abc':
//        Your function should return ['abc','acb','bac','bca','cab','cba']
//
//        With input 'aabb':
//        Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']

        System.out.println(Arrays.toString(singlePermutations("aabb").toArray()));
    }


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