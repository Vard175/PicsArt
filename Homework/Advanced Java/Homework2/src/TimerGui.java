import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TimerGui {
    private JFrame frame;
    private JPanel panel;
    public static JLabel timerLabel;
    public static Timer timer;

    public TimerGui() {
        Thread timerThread = new Thread(new TimerRunnable());

        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        timerLabel=new JLabel("");
        timerLabel.setBounds(150,250,300,100);
        timerLabel.setFont(new Font("Serif",Font.PLAIN,45));
        panel.add(timerLabel);

        JLabel inputLabel = new JLabel("Enter time(h:m:s) and click start");
        inputLabel.setBounds(10, 70, 230, 40);
        panel.add(inputLabel);

        JTextField timerInput = new JTextField(20);
        timerInput.setBounds(240, 70, 165, 40);
          panel.add(timerInput);

        JButton startButton = new JButton(new AbstractAction("Start") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input=timerInput.getText().split(":");
                timer=new Timer(input[0],input[1],input[2]);
                timerThread.start();
            }
        });

        startButton.setBounds(160,140,165,50);
        panel.add(startButton);

        frame.setVisible(true);
    }
}
