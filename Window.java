package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {

    private JFrame frame;

    public Window() {
        frame = new JFrame();
        frame.setTitle("Служба поддрежки");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(300,300,400,400);


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(textArea, BorderLayout.CENTER);


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send(textArea,textField);
            }
        });
        southPanel.add(textField, BorderLayout.CENTER);

        JButton button = new JButton("Send");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send(textArea,textField);
            }
        });
        southPanel.add(button, BorderLayout.EAST);

        frame.add(southPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    private void send(JTextArea textArea, JTextField textField) {
        StringBuilder sb = new StringBuilder(textArea.getText());
        sb.append(textField.getText() + "\n");
        textArea.setText(sb.toString());
        textField.setText("");
    }


    public static void main(String[] args) {
        new Window();
    }
}










