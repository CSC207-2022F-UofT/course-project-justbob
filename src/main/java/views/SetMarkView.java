package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.assessment.setMark.SetMarkRequest;
import ports.usecases.assessment.setMark.SetMarkWindowResponse;
import usecases.assessment.SetMark.SetMarkController;

import javax.swing.*;
import java.awt.*;

public class SetMarkView {

    public SetMarkView(EntityGateway entityGateway, EntityFactory entityFactory, SetMarkWindowResponse response, JFrame parentFrame, JFrame parentParentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // JFrame class
        JFrame frame = new JFrame();
        frame.setTitle("Set Mark of" + response.instanceName);
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 260));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mark Label constructor
        JLabel label1 = new JLabel("Enter mark:");
        label1.setBounds(100, 8, 193, 20);
        panel.add(label1);

        // Mark textfield
        JTextField mark = new JTextField();
        mark.setBounds(100, 27, 193, 28);
        panel.add(mark);

        // Set Mark Button constructor
        JButton setMarkButton = new JButton("Set Mark");
        setMarkButton.setBounds(100, 160, 193, 28);
        panel.add(setMarkButton);

        // Commit Mark Button constructor
        JButton commitMarkButton = new JButton("Commit Mark");
        commitMarkButton.setBounds(100, 200, 193, 28);
        panel.add(commitMarkButton);

        setMarkButton.addActionListener(e -> {
            double markValue = Double.parseDouble(mark.getText());

            SetMarkRequest request = new SetMarkRequest(response.username, response.courseCode, response.assessmentTitle, response.instanceNumber, markValue);
            new SetMarkController(request, frame, entityGateway, entityFactory, parentFrame, parentParentFrame);
        });

        frame.setVisible(true);
    }

}
