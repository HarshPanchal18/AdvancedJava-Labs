package org.example.Assignment3;

public class Q1 {
    /*
    Write a Java Program to inherit time class.
    (i.e. First class has the hour component, Second class has the minutes component & the Third class has a seconds component.)
    Given 2 objects, find the time lapsed between them. (Generate Documentation for your program.)
     */
    public static void main(String[] args) {
        Time time1 = new Time(4,9,8);
        Time time2 = new Time(2,9,8);

        Time diff = Time.timeElapsed(time1, time2);
        System.out.println(diff.hour + ":" + diff.minute + ":" + diff.second);
    }
}