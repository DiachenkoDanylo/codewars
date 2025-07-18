package com.diachenko;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Hello world!
 */
public class App {
    /*
    The book "Guide to Teaching Puzzle-based Learning" includes the following puzzle:
    "A boy sometimes misses the bus. The bus is supposed to leave at 8:00, but it arrives at the stop some time between 7:58 and 8:02 and departs immediately once everyone is on board.
    The boy tries to reach the stop early, but due to various circumstances he arrives some time between 7:55 and 8:01. How often does the boy miss the bus?" (Text edited for brevity.)
    The book explains how to find the solution, which is 18.75%.
    Let's solve this problem in general. Inputs are the bus range first, followed by the boy range. Both ranges are tuples (or lists or arrays, depending on language) of two elements;
    the second time is guaranteed to be later than the first. The bus and boy are equally likely to arrive at any time in their range.
    You don't have to take into account the time that the bus waits - assume people board the bus instantly :-).
    The boy makes the bus only if he arrives before or at the moment it does. Compute how often the boy misses the bus, as a percentage.
    Times are given as strings containing hour, minute, and AM/PM. Example: (("7:58 AM", "8:02 AM"), ("7:55 AM", "8:01 AM")) should return 18.75 Answers are accepted if within 0.001 of the solution.
    Note: The bus runs between 2am and 11pm. The boy's times will be sufficiently close to the bus times so that calculating across to the previous or next day is not needed.
     */
    public static void main(String[] args) {
        System.out.println("ANSWER = : " + catchTheBus(new String[]{"11:35 AM", "12:02 PM"}, new String[]{"11:45 AM", "11:51 AM"}));
        System.out.println("ACTUAL ANSWER = : " + "48.148");

    }


    public static double catchTheBus(final String[] busTimes, final String[] boyTimes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
        LocalTime busStart = LocalTime.parse(busTimes[0], formatter);
        LocalTime busEnd = LocalTime.parse(busTimes[1], formatter);
        LocalTime boyStart = LocalTime.parse(boyTimes[0], formatter);
        LocalTime boyEnd = LocalTime.parse(boyTimes[1], formatter);

        if (boyStart.isAfter(busEnd) ){
            return 100;
        } else if (boyEnd.isBefore(busStart) ) {
            return 0;
        }

        long boyTimeDuration = (Duration.between(boyStart, boyEnd).toSeconds() * 60 ) + 1;
        long busTimeDuration = (Duration.between(busStart, busEnd).toSeconds() * 60 ) + 1;
        long totalCounts = boyTimeDuration*busTimeDuration;

        LocalTime allStart = busStart.isAfter(boyStart) ? busStart : boyStart;
        LocalTime allEnd = busEnd.isAfter(boyEnd) ? boyEnd : busEnd;
        long notCatchTimes = Duration.between(allStart, allEnd).toSeconds() * 60;

        if (allStart.equals(busStart)){
            System.out.println( " 1 case");
        }
        if (allStart.equals(boyStart)){
            System.out.println( " 2 case");
        }
        if (allEnd.equals(boyEnd)){
            System.out.println( " 3 case");
        }
        if (allEnd.equals(busEnd)){
            System.out.println( " 4 case");
        }

        long notCatchTimesFull = 0;
        if (allStart.equals(boyStart) && allEnd.equals(busEnd)) {
            long val = Duration.between(busEnd, boyEnd).toSeconds() * 60;
            System.out.println(val);
            System.out.println(notCatchTimesFull);
            notCatchTimesFull = ((notCatchTimes*(notCatchTimes+1))/2) - (((val-1)*val)/2);
        }else {
            notCatchTimesFull = (notCatchTimes * (notCatchTimes + 1)) / 2;
        }
        float ans = ((float) notCatchTimesFull / totalCounts)*100;

        System.out.format("BUS START : %s BUS STOP : %s \n", busStart, busEnd);
        System.out.format("MALCH START : %s MALCH STOP : %s \n", boyStart, boyEnd);
        System.out.println("bus time : " + busTimeDuration);
        System.out.println("boy time : " + boyTimeDuration);
        System.out.println(ans);
        return Math.round(ans * 1000.0) / 1000.0;
    }
}
