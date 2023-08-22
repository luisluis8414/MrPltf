package com.luw.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import com.luw.inputs.KeyboardInputs;
import com.luw.inputs.MouseInputs;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private float x = 100, y = 100;
    private float xDir = 1f, yDir = 1f;
    private int xScreen, yScreen;
    private Color color;
    private Random random;

    private ArrayList<Rectangle> rects=new ArrayList<>();

    public GamePanel() {
        xScreen=1920;
        yScreen=1080;
        random = new Random();
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void addRect(int x, int y){
        Rectangle rect= new Rectangle(x, y);
        rects.add(rect);
    }

    public void changeXDelta(int val) {
        this.x += val;

    }

    public void changeYDelta(int val) {
        this.y += val;

    }

    public void setRectPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rectangle rect : rects) {
            rect.updateRect();
            rect.draw(g);
        }

        updateRectangle();
        g.setColor(color);
        g.fillRect((int) x, (int) y, 200, 50);

    }

    private void updateRectangle() {
        x += xDir;
        if (x > xScreen || x < 0) {
            xDir *= -1;
            color = getRndColor();
        }
        y += yDir;
        if (y > yScreen || y < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

    private Color getRndColor() {
            return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

    public class Rectangle {
        private float x = 100, y = 100;
        private int w, h;
        private float xDir = 1f, yDir = 1f;
        private Color color;

        public Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
            w = random.nextInt(250);
            h = random.nextInt(250);
            color = getRndColor();
        }

        private void updateRect() {
            x += xDir;
            if (x > xScreen || x < 0) {
                xDir *= -1;
                color = getRndColor();
            }
            y += yDir;
            if (y > yScreen || y < 0) {
                yDir *= -1;
                color = getRndColor();
            }
        }

        private Color getRndColor() {
            return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect((int) x, (int) y, w, h);
        }
    }

}
