package com.l3.gl.view;

import javax.swing.*;
import java.awt.*;
import com.l3.gl.controller.Controller;

public class LoginUI {
    private JFrame frame;

    public LoginUI(Controller controller) {
        frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton btnConnect = new JButton("Connecter");
        JButton btnQuit = new JButton("Quitter");

        btnConnect.addActionListener(e -> {
            frame.dispose();
            controller.showTaskUI();
        });

        btnQuit.addActionListener(e -> System.exit(0));

        frame.add(btnConnect);
        frame.add(btnQuit);
        frame.setVisible(true);
    }
}