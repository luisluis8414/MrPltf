package com.luw.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.luw.inputs.KeyboardInputs;
import com.luw.inputs.MouseInputs;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private float x = 100, y = 100;
    private BufferedImage img, subImg;

    public GamePanel(){
        mouseInputs= new MouseInputs(this);

        importImg();

        setPanelSize();
        keyboardInputs= new KeyboardInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img=ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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


        subImg=img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subImg, (int)x, (int)y, 128, 80, null);

    }

    
}
