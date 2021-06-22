package gui;

import model.Folder;
import threadsAndRunnables.FolderSizeRunnable;

import javax.swing.*;
import java.awt.*;

public class FolderSizeGui {
    private JFrame frame;
    private JPanel panel;
    public static JLabel sizeOutputLabel;
    private JLabel pathInputLabel;
    private JTextField pathInputTextField;
    private JButton calculateButton;
    public static Folder folder;

    public FolderSizeGui() {
        frame = new JFrame();
        panel = new JPanel();
        sizeOutputLabel = new JLabel("");
        pathInputLabel = new JLabel("Enter path (drive:\\folder...\\folder)");
        pathInputTextField = new JTextField(20);
        calculateButton = new JButton("Calculate Size");

        setSizeAndPosition();
        setStyle();
        addToPanel();
        addButtons();
    }

    private void setStyle() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        pathInputLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        pathInputTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        calculateButton.setFont(new Font("Serif", Font.PLAIN, 30));
        sizeOutputLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        frame.setVisible(true);
    }

    private void setSizeAndPosition() {
        frame.setSize(500, 500);
        pathInputLabel.setBounds(5, 60, 450, 40);
        pathInputTextField.setBounds(100, 115, 250, 40);
        calculateButton.setBounds(110, 200, 230, 50);
        sizeOutputLabel.setBounds(150, 250, 300, 100);
    }

    private void addToPanel() {
        frame.add(panel);
        panel.add(pathInputLabel);
        panel.add(pathInputTextField);
        panel.add(calculateButton);
        panel.add(sizeOutputLabel);
    }

    private void addButtons() {
        calculateButton.addActionListener(e1 -> {
            String path = pathInputTextField.getText();
            folder = new Folder(path, 0);
            Thread sizeCalculatorThread = new Thread(new FolderSizeRunnable());
            sizeCalculatorThread.start();
        });
    }
}
