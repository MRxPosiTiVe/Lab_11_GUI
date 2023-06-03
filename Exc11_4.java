import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Exc11_4 extends JFrame {

    private JTextField outputField;
    private JButton generateButton;

    public Exc11_4() {
        setTitle("Генератор случайных чисел");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        outputField = new JTextField(10);
        outputField.setEditable(false);

        generateButton = new JButton("Генерировать");
        generateButton.setPreferredSize(new Dimension(100, 50)); // Установка размеров кнопки
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomNumbers();
            }
        });

        panel.add(outputField, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void generateRandomNumbers() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(100);
            builder.append(randomNumber).append("\n");
        }

        outputField.setText(builder.toString());
    }

    public static void main(String[] args) {
        new Exc11_4();
    }
}
