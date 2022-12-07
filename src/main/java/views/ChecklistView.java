package views;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.checklist.showChecklist.ShowChecklistRequest;
import ports.usecases.checklist.showChecklist.ShowChecklistResponse;
import usecases.checklist.ShowChecklistUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChecklistView {

    public ChecklistView(EntityGateway entityGateway, EntityFactory entityFactory,
                         String username, String name){



        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        frame.setSize(500, 800);
        frame.add(panel);
        frame.setVisible(true);

        JLabel title = new JLabel("Assignment Checklist");
        title.setBounds(150, 0, 200, 25);
        title.setFont(new Font("Georgia", Font.BOLD, 16));
        panel.add(title);

        JCheckBox showTodo = new JCheckBox("Show Tasks Unfinished", true);
        showTodo.setBounds(5, 540, 200, 25);
        showTodo.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(showTodo);

        JCheckBox showCommitted = new JCheckBox("Show Tasks Committed");
        showCommitted.setBounds(5, 570, 200, 25);
        showCommitted.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(showCommitted);

        JCheckBox showSubmitted = new JCheckBox("Show Tasks Submitted");
        showSubmitted.setBounds(5, 600, 200, 25);
        showSubmitted.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(showSubmitted);

        JCheckBox showDetail = new JCheckBox("Show Detail");
        showDetail.setBounds(5, 630, 200, 25);
        showDetail.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(showDetail);

        JCheckBox sortInDDL = new JCheckBox("Sort In Due Time");
        sortInDDL.setBounds(5, 660, 200, 25);
        sortInDDL.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(sortInDDL);

        JCheckBox sortInMark = new JCheckBox("Sort In Due Time");
        sortInMark.setBounds(5, 690, 200, 25);
        sortInMark.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(sortInMark);

        ShowChecklistRequest request = new ShowChecklistRequest(username, showTodo.isSelected(),
                showCommitted.isSelected(), showSubmitted.isSelected(), showDetail.isSelected(), sortInDDL.isSelected(),
                sortInMark.isSelected());
        ShowChecklistUseCase showChecklistUseCase = new ShowChecklistUseCase(entityGateway);

        ShowChecklistResponse response = showChecklistUseCase.execute(request);

        JTextArea checklistField = new JTextArea();
        checklistField.setBounds(0, 30, 500, 500);
        checklistField.setEditable(false);
        if (response.taskChecklist == null){
            checklistField.append("No Tasks");
        } else {
            checklistField.append(response.taskChecklist.toString());
        }
        panel.add(checklistField);

        JButton refresher = new JButton("Refresh the Checklist");
        refresher.setBounds(200, 690, 200, 25);
        refresher.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(refresher);

        refresher.addActionListener(e -> {
            if (sortInDDL.isSelected() && sortInMark.isSelected()){
                JOptionPane.showMessageDialog(null, "Cannot Select Both Sort Ways",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (response.taskChecklist != null){
                if (showTodo.isSelected()) {
                    response.taskChecklist.toShowToDo();
                } else {
                    response.taskChecklist.toNotShowToDo();
                }
                if (showCommitted.isSelected()){
                    response.taskChecklist.toShowCommitted();
                } else {
                    response.taskChecklist.toNotShowCommitted();
                }
                if (showSubmitted.isSelected()){
                    response.taskChecklist.toShowSubmitted();
                } else {
                    response.taskChecklist.toShowSubmitted();
                }
                if (showDetail.isSelected()){
                    response.taskChecklist.toShowDetail();
                } else {
                    response.taskChecklist.toNotShowDetail();
                }
                if (sortInDDL.isSelected()){
                    response.taskChecklist.sortInDDL();
                }
                if (sortInMark.isSelected()){
                    response.taskChecklist.sortInMark();
                }
            }
            checklistField.setText("");
            if (response.taskChecklist == null){
                checklistField.append("No Tasks");
            } else {
                checklistField.append(response.taskChecklist.toString());
            }
        });


    }
}
