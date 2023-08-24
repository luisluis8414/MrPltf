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
import static com.luw.utils.Constants.PlayerConstants.*;
import static com.luw.utils.Constants.Directions.*;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private float x = 100, y = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex , aniSpeed = 15;
    private int playerAction =  IDLE;
    private int playerDirection = -1;
    private boolean moving=false;

    public GamePanel(){
        mouseInputs= new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSize();
        keyboardInputs= new KeyboardInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations(){
        animations= new BufferedImage[9][6];
        for(int j=0;j<animations.length;j++){
            for(int i=0; i < animations[j].length; i++){
                        animations[j][i] =  img.getSubimage(i*64, j*40, 64, 40);
                    }
        }
        
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

    public void setDirection(int dir){
        this.playerDirection=dir;
        moving=true;
    }

    public void setMoving(boolean moving)
    {
        this.moving=moving;
    }
    
    public void updateGame(){
        updateAnimationTick();
        setAnimation();
        updatePosition();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 256, 160, null);

    }

    private void updatePosition() {
        if(moving)
        {
            switch(playerDirection){
                case LEFT:
                x-=5;
                break;
                case UP:
                y=-5;
                break;
                case RIGHT:
                x+=5;
                break;
                case DOWN:
                y+=5;
                break;
            }
        }
    }

    private void setAnimation() {
        if(moving){
            playerAction=RUNNING;
        }else{
            playerAction=IDLE;
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick>=aniSpeed)
        {
            aniTick=0;
            aniIndex++;
            if(aniIndex>=GetSpriteAmount(playerAction)){
                aniIndex=0;
            }
        }
    }

    
}
