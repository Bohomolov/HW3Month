package painterball2.ballmodel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class AgarioBall extends Thread {
    private final Dimension ballDimension;
    private final Point2D.Double ballPosition;
    private Color ballColor;
    private Ellipse2D.Double ball;
    private int diameterBall;
    private int speedX;
    private int speedY;
    private int frameWidth;
    private int frameHeight;

    public AgarioBall(double xPosition, double yPosition, int diameterBall, int speedX, int speedY, int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.diameterBall = diameterBall;
        this.ballColor = getRandomColor();
        this.speedX = speedX;
        this.speedY = speedY;
        ballPosition = new Point2D.Double(xPosition, yPosition);
        ballDimension = new Dimension(diameterBall, diameterBall);
        createNewBall();
    }

    @Override
    public void run() {
        while (true) {
            changeBallPosition();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createNewBall() {
        ball = new Ellipse2D.Double(ballPosition.getX(), ballPosition.getY(), ballDimension.getWidth(), ballDimension.getHeight());
    }

    private void changeBallPosition() {
        if (ballPosition.getX() + diameterBall >= frameWidth - (frameWidth * 0.01) - speedX || ballPosition.getX() <= 0) {
            speedX *= -1;
        } else if (ballPosition.getY() + diameterBall >= frameHeight - (frameHeight * 0.035) - speedY || ballPosition.getY() <= 0) {
            speedY *= -1;
        }
        ballPosition.setLocation(ballPosition.getX() + speedX, ballPosition.getY() + speedY);
        setCurrentBallPosition();
    }

    private void setCurrentBallPosition() {
        ball.setFrame(ballPosition, ballDimension);
    }

    public Point2D.Double getBallPosition() {
        return ballPosition;
    }

    public double getDiameterBall() {
        return diameterBall;
    }

    private Color getRandomColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public void resizeFrame(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public int getDiameter() {
        return diameterBall;
    }

    public Point2D.Double getBallCoordinates() {
        return ballPosition;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public void setDiameter(int diameter) {
        this.diameterBall = diameter;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }
}

