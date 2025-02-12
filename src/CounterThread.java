public class CounterThread extends Thread {
    private Counter counter;
    private boolean increment;

    public CounterThread(Counter counter, boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    @Override
    public void run() {
        if (increment) {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        } else {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }
        }
    }
}
