package com.luw.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
        jframe.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent arg0) {
               
            }

            @Override
            public void windowLostFocus(WindowEvent arg0) {
                 gamePanel.getGame().windowFocusLost();
            }
            
        });
    }
}
