package org.example.Assignment1;

import java.util.Random;

public class Q6 {
    // Write a Java Program to generate String data dynamically with an alphabet {'A', 'B', 'C', 'D'}.
    // Use Math.random() to generate alphabets randomly
    public static void main(String[] args) {
        Character[] characters = {'A', 'B', 'C', 'D'};
        int n = characters.length;
        Random random = new Random();

        for (int i = 0; i < characters.length; i++) {
            System.out.println(characters[random.nextInt(n)]);
        }

    }
}