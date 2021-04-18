package painterball3.container;

import painterball3.ballmodel.SteelBall;
import painterball3.listeners.CanvasListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class ContainerBalls extends JPanel {
    private final JFrame frame;
    private volatile ArrayList<SteelBall> steelBalls;

    public ContainerBalls(JFrame frame) {
        this.frame = frame;
        steelBalls = new ArrayList<>();
        this.addMouseListener(new CanvasListener(steelBalls, frame));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), frame.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        changeSpeed();
        for (SteelBall steelBall : steelBalls) {
            steelBall.resizeFrame(frame.getWidth(), frame.getHeight());
            g2d.setPaint(steelBall.getBallColor());
            createPhysicalBall(g2d, steelBall);
        }
    }

    public void repaintBall() {
        repaint();
    }

    private void createPhysicalBall(Graphics2D g2d, SteelBall steelBall) {
        g2d.fillOval((int) steelBall.getBallPosition().getX(), (int) steelBall.getBallPosition().getY(), (int) steelBall.getDiameterBall(), (int) steelBall.getDiameterBall());
    }

    private void changeSpeed() {
        List<SteelBall> tempBall = new ArrayList<>(steelBalls);

        for (SteelBall steelBall : tempBall) {
            for (int i = steelBalls.size() - 1; i >= 0; i--) {
                SteelBall temp = steelBalls.get(i);
                if (!temp.equals(steelBall) && getNewDistance(steelBall, temp) < getNewRadius(steelBall, temp)) {
                    resetNewSpeed(steelBall, temp);
                    break;
                }
            }
        }
    }

    private double getNewDistance(SteelBall firstBall, SteelBall secondBall) {
        return Math.sqrt(((firstBall.getBallCoordinates().getX() - secondBall.getBallCoordinates().getX()) * (firstBall.getBallCoordinates().getX() - secondBall.getBallCoordinates().getX()) + ((firstBall.getBallCoordinates().getY() - secondBall.getBallCoordinates().getY()) * (firstBall.getBallCoordinates().getY() - secondBall.getBallCoordinates().getY()))));
    }

    private double getNewRadius(SteelBall firstBall, SteelBall secondBall) {
        return firstBall.getDiameter() / 2.0 + secondBall.getDiameter() / 2.0;
    }

    private int getNewSpeedForFirsBall(int speedFirstBall, int speedSecondBall, int diameterFirstBall, int diameterSecondBall) {
        return ((diameterFirstBall - diameterSecondBall) * speedFirstBall + (2 * diameterSecondBall * speedSecondBall)) / (diameterFirstBall + diameterSecondBall);
    }

    private int getNewSpeedForSecondBall(int speedFirstBall, int speedSecondBall, int diameterFirstBall, int diameterSecondBall) {
        return ((2 * diameterFirstBall * speedFirstBall) + speedSecondBall * (diameterSecondBall - diameterFirstBall)) / (diameterFirstBall + diameterSecondBall);
    }

    private void resetNewSpeed(SteelBall firstBall, SteelBall secondBall) {
        removeStoppedBall(firstBall, secondBall);
        int speedFirstBallByX = getNewSpeedForFirsBall(firstBall.getSpeedX(), secondBall.getSpeedX(), firstBall.getDiameter(), secondBall.getDiameter());
        int speedSecondBallByX = getNewSpeedForSecondBall(firstBall.getSpeedX(), secondBall.getSpeedX(), firstBall.getDiameter(), secondBall.getDiameter());
        int speedFirstBallByY = getNewSpeedForFirsBall(firstBall.getSpeedY(), secondBall.getSpeedY(), firstBall.getDiameter(), secondBall.getDiameter());
        int speedSecondBallByY = getNewSpeedForSecondBall(firstBall.getSpeedY(), secondBall.getSpeedY(), firstBall.getDiameter(), secondBall.getDiameter());
        resetSpeed(firstBall, secondBall, speedFirstBallByX, speedSecondBallByX, speedFirstBallByY, speedSecondBallByY);
        firstBall.setBallPosition(new Point2D.Double(firstBall.getBallCoordinates().getX() + speedFirstBallByX, firstBall.getBallCoordinates().getY() + speedFirstBallByY));
        secondBall.setBallPosition(new Point2D.Double(secondBall.getBallCoordinates().getX() + speedSecondBallByX, secondBall.getBallCoordinates().getY() + speedSecondBallByY));
    }

    private void removeStoppedBall(SteelBall firstBall, SteelBall secondBall) {
        if (firstBall.getSpeedX() == 0 || firstBall.getSpeedY() == 0 || secondBall.getSpeedX() == 0 || secondBall.getSpeedY() == 0) {
            if (firstBall.getSpeedX() > 0 || firstBall.getSpeedY() > 0) {
                steelBalls.remove(secondBall);
            } else {
                steelBalls.remove(firstBall);
            }
        }
    }

    private void resetSpeed(SteelBall firstBall, SteelBall secondBall, int speedFirstBallByX, int speedSecondBallByX, int speedFirstBallByY, int speedSecondBallByY) {
        firstBall.setSpeedX(speedFirstBallByX);
        firstBall.setSpeedY(speedFirstBallByY);
        secondBall.setSpeedX(speedSecondBallByX);
        secondBall.setSpeedY(speedSecondBallByY);
    }
}
