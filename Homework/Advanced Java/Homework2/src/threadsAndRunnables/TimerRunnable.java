package threadsAndRunnables;

import gui.TimerGui;
import models.Timer;
import services.TimerService;

public class TimerRunnable implements Runnable {
    @Override
    public void run() {
        Timer timer = TimerGui.timer;
        String time=TimerService.format(timer.getHours(), timer.getMinutes(),timer.getSeconds());

        while (timer.getHours() != 0 || timer.getMinutes() != 0 || timer.getSeconds() != 0) {
            TimerGui.timerOutputLabel.setText(time);
            time= TimerService.calculate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        TimerGui.timerOutputLabel.setText("Պրծ ։Դ");
    }

}
