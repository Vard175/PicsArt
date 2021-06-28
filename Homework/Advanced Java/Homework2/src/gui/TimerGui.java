package gui;

import models.Timer;
import threadsAndRunnables.TimerRunnable;

import javax.swing.*;
import java.awt.*;

public class TimerGui {
    private JFrame frame;
    private JPanel panel;
    private JButton startButton;
    private JLabel timerInputLabel;
    private JTextField timerInputTextField;
    public static JLabel timerOutputLabel;
    public static models.Timer timer;
    Thread timerThread;

    public TimerGui() {
        timerThread = new Thread(new TimerRunnable());
        panel = new JPanel();
        frame = new JFrame();
        timerOutputLabel = new JLabel("");
        timerInputLabel = new JLabel("Enter time(h:m:s) and click start");
        timerInputTextField = new JTextField(20);
        startButton = new JButton("Start");
        frame.setVisible(true);

        setStyle();
        setSizeAndPosition();
        addButtons();
        addToPanel();
    }

    private void setStyle() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        timerOutputLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        startButton.setFont(new Font("Serif", Font.PLAIN, 30));
        timerInputLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        timerInputTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        frame.setVisible(true);
    }

    private void setSizeAndPosition() {
        frame.setSize(500, 500);
        timerInputLabel.setBounds(25, 60, 450, 40);
        timerInputTextField.setBounds(100, 115, 250, 40);
        startButton.setBounds(110, 200, 230, 50);
        timerOutputLabel.setBounds(150, 250, 300, 100);
    }

    private void addToPanel() {
        frame.add(panel);
        panel.add(timerOutputLabel);
        panel.add(timerInputLabel);
        panel.add(timerInputTextField);
        panel.add(startButton);
    }

    private void addButtons() {
        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            String[] input = timerInputTextField.getText().split(":");
            timer = new Timer(input[0], input[1], input[2]);
            timerThread.start();
        });
    }
}
