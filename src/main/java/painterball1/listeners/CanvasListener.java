package painterball1.listeners;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CanvasListener implements MouseMotionListener {
    private int x = 0;
    private int y = 0;
    private final JFrame jFrame;

    public CanvasListener(JFrame jFrame) {
        this.jFrame = jFrame;

    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        jFrame.repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }

}
