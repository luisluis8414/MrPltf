package com.luw.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(3);
        jframe.add(gamePanel);


        ImageIcon customIcon = new ImageIcon(getClass().getResource("/logo.png"));

        // jframe.setUndecorated(true);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setIconImage(customIcon.getImage());
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }
}
