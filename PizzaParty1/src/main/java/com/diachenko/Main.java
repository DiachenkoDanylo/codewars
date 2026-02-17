package com.diachenko;


/*  Codewars
    17.02.2026
    @author DiachenkoDanylo
*/

public class Main {
    public static void main(String[] args) {
        String[] pizzaSlices = {"1/2", "1/2", "1/2", "1/2"};
        String[] pizzaSlices2 = {"1/4", "3/4", "1/2"};
        String[] pizzaSlices3 = {""};
        String[] pizzaSlices4 = null;

        System.out.println(numberOfPizzasToOrder(pizzaSlices));
        System.out.println(numberOfPizzasToOrder(pizzaSlices2));
        System.out.println(numberOfPizzasToOrder(pizzaSlices3));
        System.out.println(numberOfPizzasToOrder(pizzaSlices4));
    }

    public static int numberOfPizzasToOrder(String[] slicesOfPizza) {
        if (slicesOfPizza == null || slicesOfPizza.length == 0) {
            return 0;
        }
        long[] noms = new long[slicesOfPizza.length];
        long[] denoms = new long[slicesOfPizza.length];
        for (int i = 0; i < slicesOfPizza.length; i++) {
            int slash = slicesOfPizza[i].indexOf('/');
            if (slash == -1) {
                return 0;
            }
            noms[i] = Long.parseLong(slicesOfPizza[i].substring(0, slash));
            denoms[i] = Long.parseLong(slicesOfPizza[i].substring(slash + 1));
        }
        long cd = lcm(denoms);
        long total = 0;
        for (int i = 0; i < slicesOfPizza.length; i++) {
            total += noms[i] * (cd / denoms[i]);
        }
        return (int) Math.ceil((double) total / cd);
    }

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }
}