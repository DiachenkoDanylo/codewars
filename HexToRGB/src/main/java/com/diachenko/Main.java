package com.diachenko;


/*  codewars Project
    28.01.2026
    @author DiachenkoDanylo
*/

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(hexStringToRGB("#111111"));
//        r17g17b17

        System.out.println(hexStringToRGB("#FF9933"));
//        r255g153b51
    }

    public static HashMap<String, Integer> hexStringToRGB(String hex) {
        HashMap<String, Integer> map = new HashMap<>();
        String rgb = "rgb";
        hex = hex.substring(1);
        for (int i = 0; i < 3; i++) {
            map.put(String.valueOf(rgb.charAt(i)), Integer.valueOf(hex.substring(i * 2, (i + 1) * 2), 16));
        }
        return map;
    }
}