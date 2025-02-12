public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        CounterThread incrementThread = new CounterThread(counter, true);
        CounterThread decrementThread = new CounterThread(counter, false);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final counter value: " + counter.getCount());
    }
}
