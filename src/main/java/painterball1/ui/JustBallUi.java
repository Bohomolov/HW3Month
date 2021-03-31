package painterball1.ui;

import painterball1.container.ContainerBalls;

import javax.swing.*;

public class JustBallUi extends JFrame {
    private final JFrame jFrame = new JFrame("JustBalls");
    private final ContainerBalls ballContainer = new ContainerBalls(jFrame);

    public JustBallUi() {
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
