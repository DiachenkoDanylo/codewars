package com.diachenko;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
//    Given a string of words, you need to find the highest scoring word.
//    Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
//    For example, the score of abad is 8 (1 + 2 + 1 + 4).
//    You need to return the highest scoring word as a string.
//    If two words score the same, return the word that appears earliest in the original string.
//    All letters will be lowercase and all inputs will be valid.

    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud"));
    }
    private static final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String high(String s) {
        String[] words = s.split(" ");
        String highestScoringWord = "";
        int maxScore = -1;

        for (String word : words) {
            int score = 0;
            for (int j = 0; j < word.length(); j++) {
                score += abc.indexOf(Character.toUpperCase(word.charAt(j))) + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                highestScoringWord = word;
            }
        }
        return highestScoringWord;
    }


//    Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
//    Rules for a smiling face:
//    Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
//    A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
//    Every smiling face must have a smiling mouth that should be marked with either ) or D
//    No additional characters are allowed except for those mentioned.
//    Valid smiley face examples: :) :D ;-D :~)
//    Invalid smiley faces: ;( :> :} :]
    public static int countSmileys(List<String> arr) {
        String regex = "[:;][-~]?[)D]";
        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        for (String face : arr) {
            Matcher matcher = pattern.matcher(face);
            if (matcher.matches()) {
                count++;
            }
        }
        return count;
    }
}
