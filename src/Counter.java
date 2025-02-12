import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private int count_1 = 0;
    private int count_2 = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        synchronized(this) {
            count++;
        }
    }

    public void decrement() {
        synchronized(this) {
            count--;
        }
    }


    public synchronized void increment_1() {
        count_1++;
    }

    public synchronized void decrement_1() {
        count_1--;
    }

    public void increment_2() {
        lock.lock();
        try {
            count_2++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement_2() {
        lock.lock();
        try {
            count_2--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public int getCount_1() {
        return count_1;
    }

    public int getCount_2() {
        return count_2;
    }
}

