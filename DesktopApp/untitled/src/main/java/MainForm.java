import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainForm {
    private JPanel mainPanel;
    private JButton joinButton;
    private JButton separateButton;
    private JTextField tfSecondName;
    private JTextField tfFirstName;
    private JTextField tfThirdName;
    private JPanel separated;
    private JTextField fullName;
    private JPanel joined;
    private JPanel cardPanel;

    public MainForm(){
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secondName = tfSecondName.getText();
                String firstName = tfFirstName.getText();
                String thirdName = tfThirdName.getText();
                String errorText = "Не все данные введены, заполните поля \"Фамилия\" и \"Имя\"";
                if (secondName.isBlank() || firstName.isBlank()){
                    JOptionPane.showMessageDialog(null, errorText, "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    fullName.setText(secondName + " " + firstName + " " + thirdName);
                    tfSecondName.setText("");
                    tfFirstName.setText("");
                    tfThirdName.setText("");
                    joinButton.setVisible(false);
                    separateButton.setVisible(true);
                    separated.setVisible(false);
                    joined.setVisible(true);
                }
            }
        });

        separateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullNameText = fullName.getText();
                String regex = "^([A-Za-zА-Яа-яеЕёЁ]+)\\s+([A-Za-zА-Яа-яеЕёЁ]+)(?:\\s+([A-Za-zА-Яа-яеЕёЁ]+))?$"; // регулярное выражение для поиска двух или трех слов

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(fullNameText);

                String secondName = null;
                String firstName = null;
                String thirdName = null;

                if (matcher.matches()) {
                    secondName = matcher.group(1); // первое найденное слово
                    firstName = matcher.group(2); // второе найденное слово
                    thirdName = matcher.group(3); // третье найденное слово (если есть)
                }

                if (secondName != null && firstName != null) {
                    tfSecondName.setText(secondName);
                    tfFirstName.setText(firstName);
                    if (thirdName != null) {
                        tfThirdName.setText(thirdName);
                    }
                    joinButton.setVisible(true);
                    separateButton.setVisible(false);
                    joined.setVisible(false);
                    separated.setVisible(true);
                    fullName.setText("");
                } else {
                    String errorText = "Не все данные введены, введите фамилию и имя";
                    JOptionPane.showMessageDialog(null, errorText, "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
