package com.diachenko;


/*  Default (Template) Project
    12.01.2026
    @author DiachenkoDanylo
*/

public class Main {

//    Complete the solution so that the function will break up camel casing, using a space between words.
//
//    Example
//      "camelCasing"  =>  "camel Casing"
//      "identifier"   =>  "identifier"
//      ""             =>  ""

    private final static String LOREN = "LoremIpsumDolorSitAmetConsecteturAdipiscingElitSedDoEiusmodTemporIncididuntUtLaboreEtDoloreMagnaAliquaUtEnimAdMinimVeniamQuisNostrudExercitationUllamcoLaborisNisiUtAliquipExEaCommodoConsequatDuisAuteIrureDolorInReprehenderitInVoluptateVelitEsseCillumDoloreEuFugiatNullaPariaturExcepteurSintOccaecatCupidatatNonProidentSuntInCulpaQuiOfficiaDeseruntMollitAnimIdEstLaborum";
    private final static String LOREN_TRIM = "Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit Sed Do Eiusmod Tempor Incididunt Ut Labore Et Dolore Magna Aliqua Ut Enim Ad Minim Veniam Quis Nostrud Exercitation Ullamco Laboris Nisi Ut Aliquip Ex Ea Commodo Consequat Duis Aute Irure Dolor In Reprehenderit In Voluptate Velit Esse Cillum Dolore Eu Fugiat Nulla Pariatur Excepteur Sint Occaecat Cupidatat Non Proident Sunt In Culpa Qui Officia Deserunt Mollit Anim Id Est Laborum";

    public static void main(String[] args) {
        warmUp();
        benchmark("solution 1", () -> camelCase(LOREN));
        benchmark("solution 2", () -> camelCase2(LOREN));

        System.out.println(camelCase(LOREN).equals(LOREN_TRIM));
        System.out.println(camelCase2(LOREN).equals(LOREN_TRIM));
    }

    static void warmUp() {
        for (int i = 0; i < 50_000; i++) {
            camelCase(LOREN);
            camelCase2(LOREN);
        }
    }

    static void benchmark(String name, Runnable task) {
        long start = System.nanoTime();
        for (int i = 0; i < 50_000; i++) {
            task.run();
        }
        long time = System.nanoTime() - start;
        System.out.println(name + ": " + time / 1_000_000 + " ms");
    }

    // 1 Char[]
    public static String camelCase(String input) {
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isWhitespacePrev = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (i > 1) {
                isWhitespacePrev = Character.isWhitespace(arr[i - 1]);
            }
            if (!isWhitespacePrev) {
                if (Character.isUpperCase(c) && i >= 1) {
                    sb.append(" ");
                }
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 2 REGEX ( 5-10 times slower)
    public static String camelCase2(String input) {
        return input.replaceAll("(?<!^)(?<!\\s)([A-Z])", " $1");
    }

}