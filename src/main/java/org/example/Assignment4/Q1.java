package org.example.Assignment4;

import org.example.Assignment3.Time;

public class Q1 {
    /*
    Write a Java Program (Use Package) to inherit time class. (i.e. First class has the hours component, Second class has the minutes component & the Third class has a seconds component.)
    Given 2 objects, find the time lapsed between them.
     */
    public static void main(String[] args) {
        Time t1 = new Time(7, 8, 45);
        Time t2 = new Time(3, 53, 29);

        Time diff = Time.timeElapsed(t1, t2);
        System.out.println(diff.getHour() + ":" + diff.getMinute() + ":" + diff.getSecond());
    }
}