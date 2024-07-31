package org.example.Assignment1;

import java.math.BigInteger;

public class Q5 {
    // Write a Java Program to find the factorial of 50. (Use Recursive function)
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(50)));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}