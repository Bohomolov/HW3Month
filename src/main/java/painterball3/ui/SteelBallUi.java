package painterball3.ui;

import painterball3.container.ContainerBalls;

import javax.swing.*;

public class SteelBallUi extends JFrame {
    private final JFrame jFrame = new JFrame("SteelBalls");
    private final ContainerBalls ballContainer = new ContainerBalls(jFrame);

    public SteelBallUi() {
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(1000, 1000);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(ballContainer);
        while (true) {
            jFrame.repaint();
            ballContainer.repaintBall();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
