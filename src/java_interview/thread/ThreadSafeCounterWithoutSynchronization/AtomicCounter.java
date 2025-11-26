package java_interview.thread.ThreadSafeCounterWithoutSynchronization;

import java.util.concurrent.atomic.AtomicInteger;

/*
    This code is a simple thread-safe counter using AtomicInteger so multiple threads can safely increment a shared number
    without using locks or synchronization.
 */
public class AtomicCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        System.out.println(counter.incrementAndGet());
    }
}
