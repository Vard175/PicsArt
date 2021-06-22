import javax.swing.*;
import java.awt.*;

public class FolderSizeGui {
    private JFrame frame;
    private JPanel panel;
    public static JLabel sizeLabel;
    private JLabel inputPathLabel;
    private JTextField pathInput;
    private JButton calculateButton;
    public static Folder folder;

    public FolderSizeGui() {
        frame = new JFrame();
        panel = new JPanel();
        sizeLabel = new JLabel("");
        inputPathLabel = new JLabel("Enter path (drive:\\folder...\\folder)");
        pathInput = new JTextField(20);
        calculateButton = new JButton("Calculate Size");

        setSizeAndPosition();
        setStyle();
        addToPanel();
        addButtons();
    }

    private void setStyle() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        inputPathLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        pathInput.setFont(new Font("Serif", Font.PLAIN, 20));
        calculateButton.setFont(new Font("Serif", Font.PLAIN, 30));
        sizeLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        frame.setVisible(true);
    }

    private void setSizeAndPosition() {
        frame.setSize(500, 500);
        inputPathLabel.setBounds(5, 60, 450, 40);
        pathInput.setBounds(100, 115, 250, 40);
        calculateButton.setBounds(110, 200, 230, 50);
        sizeLabel.setBounds(150, 250, 300, 100);
    }

    private void addToPanel() {
        frame.add(panel);
        panel.add(inputPathLabel);
        panel.add(pathInput);
        panel.add(calculateButton);
        panel.add(sizeLabel);
    }

    private void addButtons() {
        calculateButton.addActionListener(e1 -> {
            String path = pathInput.getText();
            folder = new Folder(path, 0);
            Thread sizeCalculatorThread = new Thread(new FolderSizeRunnable());
            sizeCalculatorThread.start();
        });
    }
}
