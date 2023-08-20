package com.luw.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent arg0) {
        System.out.println("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        System.out.println("Mouse Moved");
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        System.out.println("Mouse exicted");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }
    
    
}
