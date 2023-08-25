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
import static com.luw.main.Game.GAME_WIDTH;
import static com.luw.main.Game.GAME_HEIGHT;;


public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private Game game;

   

    public GamePanel(Game game){
        mouseInputs= new MouseInputs(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    private void setPanelSize(){
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Gamesize: " + GAME_WIDTH + " x " + GAME_HEIGHT);
    }
    
    public void updateGame(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame(){
        return game;
    }

    
}
