package java_interview.thread.printABCUsingThreeThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    3 threads must print:
    Thread-1 → A
    Thread-2 → B
    Thread-3 → C
    Repeat this for 10 cycles → ABCABCABC…

✔️ Solution using ReentrantLock & Condition
   ReentrantLock is part of java.util.concurrent.locks and is an advanced replacement for the synchronized keyword.
   With synchronized, you only get one wait-set (via wait/notify) but ReentrantLock can create multiple Condition objects:
   synchronized blocks until it gets the lock but ReentrantLock can try to get the lock and fail immediately if not available.
 */
public class ABCPrinter {

    private int state = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condA = lock.newCondition();
    private final Condition condB = lock.newCondition();
    private final Condition condC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                while (state != 0) condA.await();
                System.out.println(Thread.currentThread().getName() + ": A");
                state = 1;
                condB.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                if (state != 1) condB.await();
                System.out.println(Thread.currentThread().getName() + ": B");
                state = 2;
                condC.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                if (state != 2) condC.await();
                System.out.println(Thread.currentThread().getName() + ": C");
                state = 0;
                condA.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
