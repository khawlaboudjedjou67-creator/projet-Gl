package com.l3.gl.view;

import javax.swing.*;
import java.awt.*;
import com.l3.gl.controller.Controller;
import com.l3.gl.model.Task;

public class TaskUI {
    private JFrame frame;
    private DefaultListModel<Task> model = new DefaultListModel<>();
    private JList<Task> list = new JList<>(model);

    public TaskUI(Controller controller) {
        frame = new JFrame("Gestion des tâches");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Task t : controller.getTasks()) {
            model.addElement(t);
        }

        JButton btnAdd = new JButton("Ajouter");
        JButton btnDelete = new JButton("Supprimer");
        JButton btnQuit = new JButton("Quitter");

        btnAdd.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Titre:");
            String date = JOptionPane.showInputDialog("Date:");
            String time = JOptionPane.showInputDialog("Heure:");

            if (title != null && date != null && time != null) {
                Task t = new Task(title, date, time);
                controller.addTask(t);
                model.addElement(t);
            }
        });

        btnDelete.addActionListener(e -> {
            Task selected = list.getSelectedValue();
            if (selected != null) {
                controller.removeTask(selected);
                model.removeElement(selected);
            }
        });

        btnQuit.addActionListener(e -> System.exit(0));

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnDelete);
        buttons.add(btnQuit);

        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}