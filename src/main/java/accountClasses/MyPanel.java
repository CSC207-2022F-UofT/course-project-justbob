package accountClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private String username;
    private String password;
    private JButton loginButton;
    private JButton registerButton;
    private JButton confirmButton1;
    private JButton confirmButton2;
    private JButton backToFront;
    private JButton intoSemester;
    private JButton intoArchive;
    public JLabel instruction;
    private JTextField usernameBox;
    private JTextField passwordBox;
    private JButton backToAccount;
    private JButton archiveGpa;

    public MyPanel(){
        this.setLayout(null);
    }

    public void isFrontPage(){
        this.removeAll();

        this.setBounds(250, 300, 300, 200);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 40, 100, 50);
        registerButton.addActionListener(this);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 100, 50);
        loginButton.addActionListener(this);

        instruction = new JLabel("Please login or register account");
        instruction.setBounds(60, 170, 200, 20);

        this.add(registerButton);
        this.add(loginButton);
        this.add(instruction);

        this.revalidate();
        this.repaint();
    }

    public void isLoginPage(){
        this.removeAll();

        this.setBounds(200, 250, 400, 300);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(80, 100, 80, 20);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 150, 80, 20);

        usernameBox = new JTextField();
        usernameBox.setBounds(160, 100, 150, 20);
        passwordBox = new JTextField();
        passwordBox.setBounds(160, 150, 150, 20);

        confirmButton1 = new JButton("Confirm");
        confirmButton1.setBounds(300, 250, 90, 30);
        confirmButton1.addActionListener(this);

        backToFront = new JButton("Back");
        backToFront.setBounds(20, 20, 90, 30);
        backToFront.addActionListener(this);

        instruction = new JLabel("Please enter your credentials");
        instruction.setBounds(100, 200, 200, 20);

        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(confirmButton1);
        this.add(backToFront);
        this.add(instruction);

        this.revalidate();
        this.repaint();
    }

    public void isRegisterPage(){
        this.removeAll();

        this.setBounds(200, 250, 400, 300);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(80, 100, 80, 20);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 150, 80, 20);

        usernameBox = new JTextField();
        usernameBox.setBounds(160, 100, 150, 20);
        passwordBox = new JTextField();
        passwordBox.setBounds(160, 150, 150, 20);

        confirmButton2 = new JButton("Confirm");
        confirmButton2.setBounds(300, 250, 90, 30);
        confirmButton2.addActionListener(this);

        backToFront = new JButton("Back");
        backToFront.setBounds(20, 20, 90, 30);
        backToFront.addActionListener(this);

        instruction = new JLabel("<html>" + "Please enter username and password, both must be 8-16 characters"+ "<html>");
        instruction.setBounds(5, 185, 400, 20);

        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(confirmButton2);
        this.add(backToFront);
        this.add(instruction);

        this.revalidate();
        this.repaint();
    }

    public void isAccountPage(){
        this.removeAll();

        this.setBounds(250, 300, 300, 200);

        intoSemester = new JButton("Semester");
        intoSemester.setBounds(40, 80, 100, 50);
        intoSemester.addActionListener(this);

        intoArchive = new JButton("Archive");
        intoArchive.setBounds(160, 80, 100, 50);
        intoArchive.addActionListener(this);

        this.add(intoSemester);
        this.add(intoArchive);

        this.revalidate();
        this.repaint();
    }

    public void isArchivePage(){
        this.removeAll();

        this.setBounds(0, 0, 800, 800);

        backToAccount = new JButton("Back");
        backToAccount.setBounds(20, 20, 80, 30);
        backToAccount.addActionListener(this);

        archiveGpa = new JButton("Update GPA");
        archiveGpa.setBounds(650, 20, 120, 30);
        archiveGpa.addActionListener(this);

        // List<JLabel> courseLabels = new Arraylist<>();
        // for(String course : AccountController.extractArchived()){
        //     courselabels.add(new JLabel(course))
        // }

        this.add(backToAccount);
        this.add(archiveGpa);

        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            this.isLoginPage();
        } else if (e.getSource() == registerButton) {
            this.isRegisterPage();
        } else if (e.getSource() == backToFront) {
            this.isFrontPage();
        } else if (e.getSource() == confirmButton1) {
            username = usernameBox.getText();
            password = passwordBox.getText();
            AccountController.loginStatus(username, password, this);
        } else if (e.getSource() == confirmButton2) {
            username = usernameBox.getText();
            password = passwordBox.getText();
            AccountController.registerStatus(username, password, this);
        } else if (e.getSource() == intoArchive) {
            this.isArchivePage();
        } else if (e.getSource() == backToAccount) {
            this.isAccountPage();
        }
    }
}
