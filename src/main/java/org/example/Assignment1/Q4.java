package org.example.Assignment1;

public class Q4 {
    // Write a Java Program to find the generate the first 50 numbers of Fibonacci Series.
    public static void main(String[] args) {
        long sum, a = 0, b = 1;

        System.out.println(0);
        System.out.println(1);
        for (int i = 1; i <= 48; i++) {
            sum = a + b;
            System.out.println(sum);
            a = b;
            b = sum;
        }
    }
}