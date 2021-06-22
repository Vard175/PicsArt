package models;

public class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    public Timer(String hours, String minutes, String seconds) {
        setHours(Integer.parseInt(hours));
        setMinutes(Integer.parseInt(minutes));
        setSeconds(Integer.parseInt(seconds));
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
