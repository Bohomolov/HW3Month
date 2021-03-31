package painterball1.listeners;

import painterball1.ballmodel.JustBall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class CanvasListener extends MouseAdapter {
    private final JFrame jFrame;
    private final ArrayList<JustBall> justBalls;
    private final Random random = new Random();

    public CanvasListener(ArrayList<JustBall> justBalls, JFrame jFrame) {
        this.jFrame = jFrame;
        this.justBalls = justBalls;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jFrame.setSize(jFrame.getWidth() + 1, jFrame.getHeight() + 1);
        JustBall justBall = getNewBall(e);
        justBalls.add(justBall);
        Thread thread = new Thread(justBall);
        thread.start();

    }

    private JustBall getNewBall(MouseEvent e) {
        int speedX = getRandomSpeed(jFrame.getWidth());
        int speedY = getRandomSpeed(jFrame.getHeight());
        int diameter = getRandomDiameter();
        int x = e.getX() - diameter / 2;
        int y = e.getY() - diameter / 2;
        return new JustBall(x, y, diameter, speedX, speedY, jFrame.getWidth(), jFrame.getHeight());
    }

    private int getRandomDiameter() {
        return random.nextInt(Math.min(jFrame.getWidth(), jFrame.getHeight()) / 8 + 1);
    }

    private int getRandomSpeed(int speed) {
        int temp = speed / 100;
        int randomSpeed = random.nextInt(temp * 2) - temp;
        return randomSpeed != 0 ? randomSpeed : getRandomSpeed(speed);
    }
}
