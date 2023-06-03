import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exc11_4 extends JFrame {

    private JTextField numberField;
    private JButton generateButton;

    public Exc11_4() {
        setTitle("Генератор случайных чисел");
        setSize(200, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        numberField = new JTextField(10);
        numberField.setEditable(false);

        generateButton = new JButton("Генерировать");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomNumbers();
            }
        });

        panel.add(numberField, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void generateRandomNumbers() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int randomNumber = (int) (Math.random() * 100);
            builder.append(randomNumber).append("\n");
        }
        numberField.setText(builder.toString());
    }

    public static void main(String[] args) {
        new Exc11_4();
    }
}
