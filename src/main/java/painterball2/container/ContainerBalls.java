package painterball2.container;

import painterball2.ballmodel.AgarioBall;
import painterball2.listeners.CanvasListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContainerBalls extends JPanel {
    private final JFrame frame;
    private volatile ArrayList<AgarioBall> agarioBalls;

    public ContainerBalls(JFrame frame) {
        this.frame = frame;
        agarioBalls = new ArrayList<>();
        this.addMouseListener(new CanvasListener(agarioBalls, frame));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), frame.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        mergeTwoBalls();
        for (AgarioBall agarioBall : agarioBalls) {
            agarioBall.resizeFrame(frame.getWidth(), frame.getHeight());
            g2d.setPaint(agarioBall.getBallColor());
            createPhysicalBall(g2d, agarioBall);
        }
    }

    public void repaintBall() {
        repaint();
    }

    private void createPhysicalBall(Graphics2D g2d, AgarioBall agarioBall) {
        g2d.fillOval((int) agarioBall.getBallPosition().getX(), (int) agarioBall.getBallPosition().getY(), (int) agarioBall.getDiameterBall(), (int) agarioBall.getDiameterBall());
    }

    private void mergeTwoBalls() {
        for (AgarioBall agarioBall : agarioBalls) {
            boolean flag = true;
            for (int i = agarioBalls.size() - 1; i >= 0; i--) {
                AgarioBall temp = agarioBalls.get(i);
                if (!temp.equals(agarioBall) && getNewDistance(agarioBall, temp) < getNewRadius(agarioBall, temp)) {
                    mergeCharacteristicsTwoBalls(agarioBall, temp);
                    agarioBalls.remove(agarioBall);
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private double getNewDistance(AgarioBall firstBall, AgarioBall secondBall) {
        return Math.sqrt(((firstBall.getBallCoordinates().getX() - secondBall.getBallCoordinates().getX()) * (firstBall.getBallCoordinates().getX() - secondBall.getBallCoordinates().getX()) + ((firstBall.getBallCoordinates().getY() - secondBall.getBallCoordinates().getY()) * (firstBall.getBallCoordinates().getY() - secondBall.getBallCoordinates().getY()))));
    }

    private double getNewRadius(AgarioBall firstBall, AgarioBall secondBall) {
        return firstBall.getDiameter() / 2.0 + secondBall.getDiameter() / 2.0;
    }

    private void mergeCharacteristicsTwoBalls(AgarioBall firstBall, AgarioBall secondBall) {
        Color color = new Color(firstBall.getBallColor().getRGB() + secondBall.getBallColor().getRGB());
        secondBall.setBallColor(color);
        secondBall.setDiameter(firstBall.getDiameter() + secondBall.getDiameter());
        secondBall.setSpeedX(firstBall.getSpeedX() + secondBall.getSpeedX());
        secondBall.setSpeedY(firstBall.getSpeedY() + secondBall.getSpeedY());
    }
}
