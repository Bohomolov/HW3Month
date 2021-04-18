package painterball3.listeners;

import painterball3.ballmodel.SteelBall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class CanvasListener extends MouseAdapter {
    private final JFrame jFrame;
    private final ArrayList<SteelBall> steelBalls;
    private final Random random = new Random();

    public CanvasListener(ArrayList<SteelBall> steelBalls, JFrame jFrame) {
        this.jFrame = jFrame;
        this.steelBalls = steelBalls;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jFrame.setSize(jFrame.getWidth() + 1, jFrame.getHeight() + 1);
        SteelBall stealBall = getNewBall(e);
        steelBalls.add(stealBall);
        Thread thread = new Thread(stealBall);
        thread.start();
    }

    private SteelBall getNewBall(MouseEvent e) {
        int speedX = getRandomSpeed(jFrame.getWidth());
        int speedY = getRandomSpeed(jFrame.getHeight());
        int diameter = getRandomDiameter();
        int x = e.getX() - diameter / 2;
        int y = e.getY() - diameter / 2;
        return new SteelBall(x, y, diameter, speedX, speedY, jFrame.getWidth(), jFrame.getHeight());
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
