package org.example.Assignment4;

public class Q2 {
    // Write a Java Program (Use Package & Interface) to implement the shape class &
    // Find the areas & volumes of each of the objects created for the inherited classes.

    public static void main(String[] args) {

        Shape cube1 = new Cube(10);
        Shape cube2 = new Cube(45);
        System.out.println("Cube area: " + cube1.area());
        System.out.println("Cube Volume: " + cube2.volume());
        System.out.println();

        Shape bar1 = new Bar(10, 48, 26);
        Shape bar2 = new Bar(3, 9, 6);
        System.out.println("Bar area: " + bar1.area());
        System.out.println("Bar volume: " + bar2.volume());
        System.out.println();

        Shape sphere1 = new Sphere(9);
        Shape sphere2 = new Sphere(4);
        System.out.println("Sphere area: " + sphere1.area());
        System.out.println("Sphere volume: " + sphere2.volume());
    }
}