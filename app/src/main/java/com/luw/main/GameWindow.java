package com.luw.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();
        jframe.setSize(1920, 1080);
        jframe.setDefaultCloseOperation(3);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);

        ImageIcon customIcon = new ImageIcon("ressources/logo.png");

        // jframe.setUndecorated(true);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setIconImage(customIcon.getImage());
        jframe.setVisible(true);
    }
}
