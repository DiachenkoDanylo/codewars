package com.diachenko;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        Create a function that accepts a parameter representing a name and returns the message:
//        "Hello, <name> how are you doing today?".
//[Make sure you type the exact thing I wrote or the program may not execute properly]
        System.out.println("Hello World!");
        System.out.println(greet("Oleg"));
    }

    public static String greet(String name) {
        return   "Hello, " + name + " how are you doing today?";
    }

}
