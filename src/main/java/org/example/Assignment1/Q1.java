package org.example.Assignment1;

public class Q1 {
    /* Write a Java Program to add marks of two subjects. Write the same program using Command line arguments. */
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Please enter marks through Command Line.");
        } else {
            System.out.print("Total marks: ");
            System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
        }
    }
}