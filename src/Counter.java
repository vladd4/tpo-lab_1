public class Counter {
    private int count = 0;

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


//    public synchronized void increment() {
//        count++;
//    }
//
//    public synchronized void decrement() {
//        count--;
//    }


    public int getCount() {
        return count;
    }
}

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Counter {
//    private int count = 0;
//    private final Lock lock = new ReentrantLock();
//
//    public void increment() {
//        lock.lock();
//        try {
//            count++;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void decrement() {
//        lock.lock();
//        try {
//            count--;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//}
