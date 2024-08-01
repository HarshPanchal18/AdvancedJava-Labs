package org.example.Assignment2;

public class Q1 {
    // Write a Java Program to perform operations on Complex numbers. (Use objects)
    public static void main(String[] args) {
        Complex c1 = new Complex(36, 9.8);
        Complex c2 = new Complex(15, 4.2);
        Complex result;

        result = Complex.add(c1, c2);
        System.out.println(result.getReal() + " " + result.getImag());

        result = Complex.subtract(c1, c2);
        System.out.println(result.getReal() + " " + result.getImag());

        result = Complex.multiply(c1, c2);
        System.out.println(result.getReal() + " " + result.getImag());

        result = Complex.divide(c1, c2);
        System.out.println(result.getReal() + " " + result.getImag());

    }
}