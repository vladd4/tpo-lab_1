import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private int ballsInPocket = 0;

    public void add(Ball b) {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.fillOval(200, 150, 50, 50);

        ArrayList<Ball> ballsToRemove = new ArrayList<>();
        for (Ball b : balls) {
            if (!b.isInPocket()) {
                b.draw(g2);
            } else {
                ballsToRemove.add(b);
            }
        }

        g2.setColor(Color.BLACK);
        g2.drawString("Balls in pocket: " + ballsInPocket, 10, 20);

        for (Ball b : ballsToRemove) {
            balls.remove(b);
            ballsInPocket++;
        }
    }

    public void ballInPocket() {
        ballsInPocket++;
    }
}
