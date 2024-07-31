package org.example.Assignment1;

public class Q2 {
    // Write a Java Program to find the factorial of 20.
    public static void main(String[] args) {
        long factorial = 1;

        for(int i = 1; i <= 20; i++){
            factorial *= i;
        }

        System.out.println(factorial);
    }
}