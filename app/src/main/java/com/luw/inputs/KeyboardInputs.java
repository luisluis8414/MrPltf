package com.luw.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.luw.main.GamePanel;

public class KeyboardInputs implements KeyListener{

  private GamePanel gamePanel;
  public KeyboardInputs(GamePanel gamePanel){
    this.gamePanel=gamePanel;
  }

    @Override
    public void keyPressed(KeyEvent e) {
       switch(e.getKeyCode()){
        case KeyEvent.VK_W:
        System.out.println("W");
        break;
        case KeyEvent.VK_A:
        System.out.println("A");
         break;
        case KeyEvent.VK_S:
        System.out.println("S");
         break;
        case KeyEvent.VK_D:
        System.out.println("D");
         break;
       }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
         
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    
    }
    
}
