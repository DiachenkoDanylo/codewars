package com.diachenko;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(sumStrings("5213110238658","5213110238658"));
      //10426220477316

    }

    public static String sumStrings(String a, String b) {
        int[] aArr = Arrays.stream(a.split("")).mapToInt(Integer::parseInt).toArray();
        int[] bArr = Arrays.stream(b.split("")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Integer> hash = new HashMap<>();
        int[] cArr = new int[aArr.length];
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] + bArr[i] >= 10) {
                cArr[i] = (aArr[i] + bArr[i]) - 10;
                hash.put(String.valueOf(cArr[i]), 1);
            } else {
                cArr[i]= aArr[i] + bArr[i];
            }
        }
        int[] gArr = new int[cArr.length*2];
        for (int i = cArr.length-1; i > 1 ; i--) {
             if (hash.containsKey(String.valueOf(i))) {
                 gArr[i] = cArr[i]+1;
             } else {
                 gArr[i] = cArr[i];
             }
        }
        if (hash.containsKey("0")){
            gArr[0]=1;

        }

//        [5, 2, 1, 3, 1, 1, 0, 2, 3, 8, 6, 5, 8]
//        [5, 2, 1, 3, 1, 1, 0, 2, 3, 8, 6, 5, 8]
//     [1, 0, 4, 2, 6, 2, 2, 0, 4, 6, 6, 2, 0, 6]

        System.out.println(hash);
        System.out.println(Arrays.toString(cArr));

        System.out.println(Arrays.toString(aArr));
        System.out.println(Arrays.toString(bArr));
        System.out.println(Arrays.toString(gArr));
        return Arrays.toString(gArr).substring(0,cArr.length-1);

    }
}
