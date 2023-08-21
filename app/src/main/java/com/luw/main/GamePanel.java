package com.luw.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import com.luw.inputs.KeyboardInputs;
import com.luw.inputs.MouseInputs;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private float x = 100, y = 100;
    private float xDir=1f, yDir=1f;
    private Color color=new Color(150, 20, 90);
    private Random random;

    public GamePanel(){
        random=new Random();
        mouseInputs= new MouseInputs(this);
        keyboardInputs= new KeyboardInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int val)
    {
        this.x+=val;
       
    }

    public void changeYDelta(int val)
    {
        this.y+=val;
       
    }

    public void setRectPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
       
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int)x, (int)y, 200, 50);

    }

    private void updateRectangle(){
        x+=xDir;
        if(x>400||x<0){
            xDir*=-1;
            color= getRndColor();
        }
        y+=yDir;
        if(y>400||y<0){
            yDir*=-1;
            color= getRndColor();
        }
    }

    private Color getRndColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
