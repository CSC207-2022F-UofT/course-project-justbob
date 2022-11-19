package accountClasses;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        this.setSize(800, 800); //set frame size
        this.setResizable(false);
        this.setVisible(true); //make frame visible
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//make frame closable
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(80, 20, 200));
    }

    public void addPanel(JPanel panel){
        this.add(panel);
    }
}

