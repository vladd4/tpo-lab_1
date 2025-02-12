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
                counter.increment_1();
                counter.increment_2();
            }
        } else {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
                counter.decrement_1();
                counter.decrement_2();
            }
        }
    }
}
