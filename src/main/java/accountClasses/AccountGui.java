package accountClasses;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountGui implements ActionListener {
    private JFrame frame;
    private JButton registerBtn;
    private JButton loginBtn;
    private JButton confirmBtn;
    private JTextField usernameBox;
    private JTextField passwordBox;
    public static JLabel instruction;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private String username;
    private String password;
    private Boolean isLogin;

    /**
     * Creates a GUI for the login/register process
     */
    public AccountGui() {
        frame = new JFrame("Uoft Score Tracking App");

        registerBtn = new JButton("Register account");
        registerBtn.setBounds(220, 200, 150, 40);
        registerBtn.addActionListener(this); //This is the register account button

        loginBtn = new JButton("Login");
        loginBtn.setBounds(420, 200, 150, 40);
        loginBtn.addActionListener(this);  //Login button

        instruction = new JLabel("Please login or register account");
        instruction.setBounds(300, 250, 300, 30);
        //this label guides the user telling the user what to do

        frame.add(registerBtn);
        frame.add(loginBtn);
        frame.add(instruction);

        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) { //the if branch statements creates a new interface where the user can
            // enter username and password
            isLogin = Boolean.TRUE;

            registerBtn.setVisible(false);
            loginBtn.setVisible(false);
            instruction.setText("Enter Username and Password, both must be 8-16 characters");
            instruction.setBounds(220, 250, 400, 30);

            confirmBtn = new JButton("confirm");
            confirmBtn.setBounds(600, 350, 100, 40);
            confirmBtn.addActionListener(this);

            userLabel = new JLabel("Username");
            userLabel.setBounds(150, 150, 100, 30);

            passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(150, 200, 100, 30);

            usernameBox = new JTextField();
            usernameBox.setBounds(330, 150, 200, 30);

            passwordBox = new JTextField();
            passwordBox.setBounds(330, 200, 200, 30);

            frame.add(usernameBox);
            frame.add(passwordBox);
            frame.add(userLabel);
            frame.add(passwordLabel);
            frame.add(confirmBtn);
        } else { //The else branch activates when the confirm button on the new interface is clicked, which then stores
            // the user inputs and send them to AccountInteractor for credential checks.
            username = usernameBox.getText();
            password = passwordBox.getText();

            if(isLogin){
                AccountInteractor.login(username, password);
            }else{
                AccountInteractor.createAccount(username, password);
            }
        }
    }
}
