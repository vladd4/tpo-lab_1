import java.awt.Color;

public class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;

    public BallThread(Ball ball, BallCanvas canvas) {
        this.b = ball;
        this.canvas = canvas;


        if (b.getColor() == Color.RED) {
            this.setPriority(Thread.MAX_PRIORITY);
        } else {
            this.setPriority(Thread.MIN_PRIORITY);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                b.move();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
