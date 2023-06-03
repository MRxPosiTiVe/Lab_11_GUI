import javax.swing.*;
import java.io.*;

public class Exc11_2 {

    public static class Exc11_2Frame extends JFrame {

        public JTextField lastNameField;
        public JTextField firstNameField;
        public JTextField middleNameField;
        public JTextField birthDateField;
        public JTextField groupField;

        public Exc11_2Frame() {

            setTitle("Форма ввода данных");
            setSize(300, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel lastNameLabel = new JLabel("Фамилия:");
            lastNameField = new JTextField(20);
            JLabel firstNameLabel = new JLabel("Имя:");
            firstNameField = new JTextField(20);
            JLabel middleNameLabel = new JLabel("Отчество:");
            middleNameField = new JTextField(20);
            JLabel birthDateLabel = new JLabel("Дата рождения:");
            birthDateField = new JTextField(20);
            JLabel groupLabel = new JLabel("Учебная группа:");
            groupField = new JTextField(20);

            JButton saveButton = new JButton("Записать данные");
            JButton loadButton = new JButton("Загрузить данные");

            saveButton.addActionListener(e -> saveDataToFile());
            loadButton.addActionListener(e -> loadDataFile());

            JPanel panel = new JPanel();
            panel.add(lastNameLabel);
            panel.add(lastNameField);
            panel.add(firstNameLabel);
            panel.add(firstNameField);
            panel.add(middleNameLabel);
            panel.add(middleNameField);
            panel.add(birthDateLabel);
            panel.add(birthDateField);
            panel.add(groupLabel);
            panel.add(groupField);
            panel.add(saveButton);
            panel.add(loadButton);

            getContentPane().add(panel);

            setVisible(true);
        }

        private void saveDataToFile() {
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String middleName = middleNameField.getText();
            String birthDate = birthDateField.getText();
            String group = groupField.getText();
            String path = "src/groups.txt";

            try (FileWriter writer = new FileWriter(path)) {
                File file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                }
                writer.write(lastName + "\n");
                writer.write(firstName + "\n");
                writer.write(middleName + "\n");
                writer.write(birthDate + "\n");
                writer.write(group + "\n");
                writer.flush();
                JOptionPane.showMessageDialog(this, "Данные успешно записаны в файл.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Ошибка при записи в файл: " + e.getMessage());
            }
        }

        private void loadDataFile() {
            BufferedReader br = null;
            String path = "src/groups.txt";
            try {
                br = new BufferedReader(new FileReader(path));
                String lastName = br.readLine();
                String firstName = br.readLine();
                String middleName = br.readLine();
                String birthDate = br.readLine();
                String group = br.readLine();

                lastNameField.setText(lastName);
                firstNameField.setText(firstName);
                middleNameField.setText(middleName);
                birthDateField.setText(birthDate);
                groupField.setText(group);

                JOptionPane.showMessageDialog(this, "Данные успешно загружены из файла.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Ошибка при загрузке файла: " + e.getMessage());
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Exc11_2.Exc11_2Frame();
    }
}
