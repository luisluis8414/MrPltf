package com.luw.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.luw.main.GamePanel;

import static com.luw.utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

  private GamePanel gamePanel;

  public KeyboardInputs(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == 32)
      gamePanel.getGame().getPlayer().setAttacking(true);

    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
        gamePanel.getGame().getPlayer().setUp(true);
        break;
      case KeyEvent.VK_S:
        gamePanel.getGame().getPlayer().setDown(true);
        break;
      case KeyEvent.VK_A:
        gamePanel.getGame().getPlayer().setLeft(true);
        gamePanel.getGame().getPlayer().checkDir();
        ;
        break;
      case KeyEvent.VK_D:
        gamePanel.getGame().getPlayer().setRight(true);
        gamePanel.getGame().getPlayer().checkDir();
        ;
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
        gamePanel.getGame().getPlayer().setUp(false);
        break;
      case KeyEvent.VK_S:
        gamePanel.getGame().getPlayer().setDown(false);
        break;
      case KeyEvent.VK_A:
        gamePanel.getGame().getPlayer().setLeft(false);
        ;
        break;
      case KeyEvent.VK_D:
        gamePanel.getGame().getPlayer().setRight(false);
        ;
        break;
    }
  }

  @Override
  public void keyTyped(KeyEvent arg0) {

  }

}
