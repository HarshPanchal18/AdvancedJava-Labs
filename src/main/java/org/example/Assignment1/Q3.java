package org.example.Assignment1;

public class Q3 {
    // Write a Java Program to find the first 20 Prime Numbers.
    public static void main(String[] args) {
        var primeCounter = 0;
        var i = 2;

        while (primeCounter != 20) {
            if (isPrime(i)) {
                System.out.println("Number " + (primeCounter + 1) + ": " + i);
                primeCounter++;
            }
            i++;
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}