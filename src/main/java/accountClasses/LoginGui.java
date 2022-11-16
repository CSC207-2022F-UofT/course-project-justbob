package accountClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class LoginGui implements ActionListener {

    private Scanner scanner;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button1;
    private JButton button2;

    public LoginGui(){

        frame = new JFrame();

        panel = new JPanel();

        button1 = new JButton("Login");
        button1.addActionListener(this);
        button2 = new JButton("Create Account");
        button2.addActionListener(this);

        label = new JLabel("Please Login or Create Account");

        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button1);
        panel.add(button2);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new LoginGui();
    }

    public void startScanner(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startScanner();
    }
}
