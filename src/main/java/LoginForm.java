import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountResponse;
import usecases.account.LoginAccountUseCase;

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public LoginForm(EntityGateway entityGateway, EntityFactory entityFactory) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Login Page");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 225));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username label constructor
        JLabel label1 = new JLabel("Username");
        label1.setBounds(100, 8, 70, 20);
        panel.add(label1);

        // Username TextField constructor
        JTextField username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);

        // Password Label constructor
        JLabel label2 = new JLabel("Password");
        label2.setBounds(100, 55, 70, 20);
        panel.add(label2);

        // Password TextField
        JPasswordField password = new JPasswordField();
        password.setBounds(100, 75, 193, 28);
        panel.add(password);

        // Login Button constructor
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 193, 28);
        panel.add(loginButton);

        // Register Button constructor
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 140, 193, 28);
        panel.add(registerButton);

        loginButton.addActionListener(e -> {
            String inputUsername = username.getText();
            String inputPassword = new String(password.getPassword());

            LoginAccountRequest request = new LoginAccountRequest(inputUsername, inputPassword);
            LoginAccountUseCase usecase = new LoginAccountUseCase(entityGateway);
            try {
                LoginAccountResponse response = usecase.execute(request);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            RegisterForm registerForm = new RegisterForm(entityGateway, entityFactory);
            frame.dispose();
        });

        frame.setVisible(true);
    }
}
