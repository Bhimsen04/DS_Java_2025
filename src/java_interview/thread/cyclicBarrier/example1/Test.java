package java_interview.thread.cyclicBarrier.example1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    CyclicBarrier is used to ensure that no thread enters Step 2 until all 5 threads have completed Step 1.

      Step-by-Step Timeline of Execution
        ➤ Thread 1
        Does Step 1
        Reaches barrier → waits
        ➤ Thread 2
        Does Step 1
        Reaches barrier → waits
        ➤ Thread 3
        Does Step 1
        Reaches barrier → waits
        ➤ Thread 4
        Does Step 1
        Reaches barrier → waits
        ➤ Thread 5
        Does Step 1
        Reaches barrier → barrier count becomes 5 → barrier opens

        At this moment:
        The barrier action prints:
        "Step-1 completed by all workers. Moving to Step-2"
        All 5 threads are released together
        Now all execute Step 2
 */
public class Test {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("Step-1 completed by all workers. Moving to Step-2");
        });

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    processStep1();
                    barrier.await();  // wait for others
                    processStep2();
                    processStep3();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        processStep4(); // this main thread doesn't wait for workers thread
    }

    private static void processStep4() {
        System.out.println(Thread.currentThread().getName() + " Worker-1 Step 4 done");
    }

    private static void processStep3() {
        System.out.println(Thread.currentThread().getName() + " Worker-1 Step 3 done");
    }

    private static void processStep2() {
        System.out.println(Thread.currentThread().getName() + " Worker-1 Step 2 done");
    }

    private static void processStep1() {
        System.out.println(Thread.currentThread().getName() + " Worker-1 Step 1 done");
    }
}
