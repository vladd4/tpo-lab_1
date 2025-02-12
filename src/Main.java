public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        CounterThread incrementThread = new CounterThread(counter, true);
        CounterThread decrementThread = new CounterThread(counter, false);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final counter value (sync block): " + counter.getCount());
        System.out.println("Final counter value (sync method): " + counter.getCount_1());
        System.out.println("Final counter value (ReentrantLock): " + counter.getCount_2());
    }
}
