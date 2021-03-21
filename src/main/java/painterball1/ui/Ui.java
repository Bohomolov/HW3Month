package painterball1.ui;

import painterball1.listeners.CanvasListener;

import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame {
    private int x = 0;
    private int y = 0;
    public Ui() {
        setTitle("Paint");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.addMouseMotionListener(new CanvasListener(this));

        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g) {
        int size = (int)((Math.random() * this.getWidth()) / 8);
        g.setColor(Color.black);
        g.fillOval(x + 10, y + 30, size, size);
    }
}
