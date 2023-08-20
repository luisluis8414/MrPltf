package com.luw.main;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.luw.inputs.KeyboardInputs;
import com.luw.inputs.MouseInputs;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int x = 100, y = 100;

    public GamePanel(){
        mouseInputs= new MouseInputs();
        addKeyListener(new KeyboardInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

       
        g.fillRect(x, y, 200, 50);
    }
}
