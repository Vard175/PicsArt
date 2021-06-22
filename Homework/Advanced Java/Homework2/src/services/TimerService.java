package services;

import gui.TimerGui;
import models.Timer;

public class TimerService {

    public static String calculate() {
        int hours = TimerGui.timer.getHours();
        int minutes = TimerGui.timer.getMinutes();
        int seconds = TimerGui.timer.getSeconds();
        int totalSec = hours * 3600 + minutes * 60 + seconds;

        totalSec--;
        int hoursRemain = totalSec / 3600;
        int minutesRemain = (totalSec - hoursRemain * 3600) / 60;
        int secondsRemain = totalSec - hoursRemain * 3600 - minutesRemain * 60;
        TimerGui.timer.setHours(hoursRemain);
        TimerGui.timer.setMinutes(minutesRemain);
        TimerGui.timer.setSeconds(secondsRemain);

        return format(hoursRemain, minutesRemain, secondsRemain);
    }

    public static String format(int hours, int minutes, int seconds) {
        StringBuilder sb = new StringBuilder();
        sb.append((hours < 10 && hours >= 0) ? "0"+hours : hours);
        sb.append(":");
        sb.append((minutes < 10 && minutes >= 0) ? "0" + minutes : minutes);
        sb.append(":");
        sb.append((seconds < 10 && seconds >= 0) ? "0" + seconds : seconds);
        return sb.toString();
    }
}
