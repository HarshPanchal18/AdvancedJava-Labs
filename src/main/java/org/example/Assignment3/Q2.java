package org.example.Assignment3;

public class Q2 extends Vehicle {
    // Write a Java Program to inherit the vehicle class. (Generate Documentation for your program.)
    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        car.setModel("Honda Civic");
        car.setYear(2020);

        System.out.println(car.getModel() + " | " + car.getYear());
    }
}