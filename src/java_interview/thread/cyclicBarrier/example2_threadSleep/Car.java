package java_interview.thread.cyclicBarrier.example2_threadSleep;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private CyclicBarrier barrier;

    public Car(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is driving to the checkpoint.");
            /*
                The Thread.sleep() method is used to simulate the time it takes for each car (thread) to reach the checkpoint.
                The sleep time is randomized in this case, which means each car will reach the checkpoint at a different time.
             */
            Thread.sleep((long) (Math.random() * 1000)); // Simulate driving time
            System.out.println(Thread.currentThread().getName() + " reached the checkpoint.");
            barrier.await();  // Wait for other cars
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
