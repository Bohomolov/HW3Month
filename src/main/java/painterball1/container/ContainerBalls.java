package painterball1.container;

import painterball1.ballmodel.JustBall;
import painterball1.listeners.CanvasListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContainerBalls extends JPanel {
    private final ArrayList<JustBall> justBalls;
    private final JFrame frame;

    public ContainerBalls(JFrame frame) {
        this.frame = frame;
        justBalls = new ArrayList<>();
        this.addMouseListener(new CanvasListener(justBalls, frame));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), frame.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (JustBall justBall : justBalls) {
            justBall.resizeFrame(frame.getWidth(), frame.getHeight());
            g2d.setPaint(justBall.getBallColor());
            createPhysicalBall(g2d, justBall);
        }
    }

    public void repaintBall() {
        repaint();
    }

    private void createPhysicalBall(Graphics2D g2d, JustBall justBall) {
        g2d.fillOval((int) justBall.getBallPosition().getX(), (int) justBall.getBallPosition().getY(), (int) justBall.getDiameterBall(), (int) justBall.getDiameterBall());
    }
}
