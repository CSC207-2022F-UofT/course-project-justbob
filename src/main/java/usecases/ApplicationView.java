package usecases;

import ports.database.EntityFactory;
import ports.database.EntityGateway;

import javax.swing.*;
import java.awt.*;

public class ApplicationView {
    public ApplicationView(EntityGateway entityGateway, EntityFactory entityFactory, String username) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Just Bob: " + username);
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 225));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Todo
        // username

        frame.setVisible(true);

    }
}


