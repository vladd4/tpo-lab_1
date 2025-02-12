public class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;

    public BallThread(Ball ball, BallCanvas canvas) {
        this.b = ball;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10000; i++) {
                b.move();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
