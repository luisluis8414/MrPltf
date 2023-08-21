package com.luw.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(3);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);

        ImageIcon customIcon = new ImageIcon("ressources/logo.png");

        jframe.setIconImage(customIcon.getImage());
        jframe.setVisible(true);
    }
}
