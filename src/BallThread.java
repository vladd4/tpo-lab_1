class BallThread extends Thread {
    private Ball b;
    private static final int BOUNCE_LIMIT = 5;
    private int bounceCount = 0;

    public BallThread(Ball ball) {
        this.b = ball;
    }

    @Override
    public void run() {
        try {
            while (bounceCount < BOUNCE_LIMIT) {
                b.move();
                if (b.hasJustBounced()) {
                    bounceCount++;
                }
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}