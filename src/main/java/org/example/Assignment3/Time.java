package org.example.Assignment3;

public class Time extends Hour {
    public Time() {
    }

    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public static Time timeElapsed(Time time1, Time time2) {

        if(time1.getHour() > time2.getHour()) {
            int hourDifference = time1.getHour() - time2.getHour();
            int minuteDifference = time1.getMinute() - time2.getMinute();
            int secondDifference = time1.getSecond() - time2.getSecond();

            if (secondDifference < 0) {
                secondDifference += 60;
                minuteDifference--;
            }

            if (minuteDifference < 0) {
                minuteDifference += 60;
                hourDifference--;
            }

            if (hourDifference < 0) {
                hourDifference += 24;
            }

            return new Time(hourDifference, minuteDifference, secondDifference);
        } else {
            System.out.println("Time1 should be bigger than Time2.");
            return new Time();
        }
    }
}