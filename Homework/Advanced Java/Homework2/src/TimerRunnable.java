public class TimerRunnable implements Runnable {
    @Override
    public void run() {
        Timer timer = TimerGui.timer;
        while (timer.getHours() != 0 || timer.getMinutes() != 0 || timer.getSeconds() != 0) {
            TimerGui.timerLabel.setText(timer.getHours() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
            calculate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        TimerGui.timerLabel.setText(timer.getHours() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
    }

    private void calculate() {
        int hours=TimerGui.timer.getHours();
        int minutes=TimerGui.timer.getMinutes();
        int seconds=TimerGui.timer.getSeconds();
        int totalSec=hours*3600+minutes*60+seconds;

        totalSec--;
        int hoursRemain=totalSec/3600;
        int minutesRemain=(totalSec-hoursRemain*3600)/60;
        int secondsRemain=totalSec-hoursRemain*3600-minutesRemain*60;
        TimerGui.timer.setHours(hoursRemain);
        TimerGui.timer.setMinutes(minutesRemain);
        TimerGui.timer.setSeconds(secondsRemain);
    }
}
