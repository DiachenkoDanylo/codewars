package com.diachenko;


/*  Default (Template) Project
    19.07.2025
    @author DiachenkoDanylo
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(formatDuration(61));         //   1 minute 1 second
        System.out.println(formatDuration(3600));       //   1 hour
        System.out.println(formatDuration(720001261));  //   22 years, 303 days, 8 hours, 21 minutes and 1 second
        System.out.println(formatDuration(250123));     //   2 days, 21 hours, 28 minutes and 43 seconds
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int years = seconds / (24 * 3600 * 365);
        seconds %= (24 * 3600 * 365);
        int days = seconds / (24 * 3600);
        seconds %= (24 * 3600);
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;

        List<String> parts = new ArrayList<>();

        if (years > 0) parts.add(years + " year" + (years > 1 ? "s" : ""));
        if (days > 0) parts.add(days + " day" + (days > 1 ? "s" : ""));
        if (hours > 0) parts.add(hours + " hour" + (hours > 1 ? "s" : ""));
        if (minutes > 0) parts.add(minutes + " minute" + (minutes > 1 ? "s" : ""));
        if (seconds > 0) parts.add(seconds + " second" + (seconds > 1 ? "s" : ""));

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < parts.size(); i++) {
            answer.append(parts.get(i));
            if (i < parts.size() - 2) {
                answer.append(", ");
            } else if (i == parts.size() - 2) {
                answer.append(" and ");
            }
        }

        return answer.toString();
    }
}