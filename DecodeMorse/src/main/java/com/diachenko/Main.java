package com.diachenko;


/*  Default (Template) Project
    18.07.2025
    @author DiachenkoDanylo
*/

public class Main {
    public static void main(String[] args) {


//        String decodedBits = decodeBits("0000000000110011001100110000001100000011111100110011111100111111000000000000001100111111001111110011111100000011001100111111000000111111001100110000001100");
//        String decodedBits = decodeBits("110011001100");
        String decodedBits = decodeBits("11100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110");
        System.out.println("Test   : " + decodedBits);
        System.out.println("Result : " + "···· · −·−−   ·−−− ··− −·· ·");
//        System.out.println("Result : " + "···");


        System.out.println("DECODED : " + "HEY JUDE");
        System.out.println("TRY : " + decodeMorse(decodedBits));
    }


/*
    dot  - 1 unit   .
    dash - 3 unit   _
    pause in character - 1 unit
    pause in word - 3 unit
    pause between words - 7 unit
    HEY JUDE, that is   =====   ···· · −·−−   ·−−− ··− −·· ·
*/


    public static String decodeBits(String bits) {
        int currentStep = 0;
        int smallestStep = 0;
        bits = bits.indexOf("1") != 0 ? bits.substring(bits.indexOf("1")) : bits;
        int dotsPerBit = bits.indexOf("0");
        System.out.println("dots per bit : " + dotsPerBit);
        bits.indexOf("1", dotsPerBit);
        System.out.println(bits);
        System.out.println(bits.indexOf("1", dotsPerBit));
        if ( bits.indexOf("1", dotsPerBit) != -1 && (bits.indexOf("1", dotsPerBit) - dotsPerBit) < dotsPerBit) {
            dotsPerBit = bits.indexOf("1", dotsPerBit)-dotsPerBit;
        }
        currentStep = dotsPerBit;
        smallestStep = currentStep;
        System.out.println(dotsPerBit);
        if (!bits.isEmpty() && dotsPerBit == -1) {
            return ".";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String head = "1";
        String nextHead = "0";
        for (int i = 0; i != bits.length(); ) {
            int nextIndex = bits.indexOf(nextHead, i);
            int step = nextIndex - i;
            if (nextIndex == -1) {
                nextIndex = bits.length();
                step = nextIndex - i;
            }
            if(step/2 < smallestStep) {
                smallestStep = step/2;
            }

//            System.out.println("CURSOR AT : " + i);
//            System.out.println("HEAD : " + head);
//            System.out.println("NEXT " + nextHead + " AT : " + nextIndex);
//            System.out.println("STEP : " + step);
            if ("0".equals(nextHead)) {
                switch (step / dotsPerBit) {
                    case 1:
                        stringBuilder.append(".");
//                        System.out.println("BIT : · ");
                        break;
                    case 3:
                        stringBuilder.append("-");
//                        System.out.println("BIT : − ");
                        break;
                }
            } else {
                switch (step / dotsPerBit) {
                    case 1:
//                        System.out.println("BIT : NOTHING ");
                        break;
                    case 3:
                        stringBuilder.append(" ");
//                        System.out.println("BIT : space ");
                        break;
                    case 7:
                        stringBuilder.append("   ");
//                        System.out.println("BIT : WORD space  ");
                        break;
                }
            }
            head = "0".equals(head) ? "1" : "0";
            nextHead = "0".equals(head) ? "1" : "0";
            i = nextIndex;
//            System.out.println("____________________________________________________");
        }
        if (smallestStep != currentStep) {
            System.out.println("NOT RIGHT ");
        }
        return stringBuilder.toString();
    }

    public static String decodeMorse(String morseCode) {
        String words[] = morseCode.split(" {3}");

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String codes[] = words[i].split(" ");
            for (int j = 0; j < codes.length; j++) {
                res.append(MorseCode.get(codes[j]));
            }
            if (i + 1 < words.length) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    //Dictionary implemented by kata
    public static class MorseCode {
        public static String get(String code) {
            return "/";
        }
    }

}