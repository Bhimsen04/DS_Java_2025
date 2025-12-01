package java_interview.thread.countDownLatch.example1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    How This Works ?

    Thread pool has 4 threads

    But we submit 10 tasks

    Only 4 run at a time

    After each finishes, latch count decreases

    Main waits until latch count = 0

    Then main continues
 */
public class ThreadPoolLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int tasks = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(4); // 4 worker threads
        CountDownLatch countDownLatch = new CountDownLatch(tasks);

        for (int i = 0; i < tasks; i++) {
            int id = i;
            executorService.execute(() -> {
                try {
                    System.out.println("Task " + id + " started...");
                    Thread.sleep(500 + (id * 100)); // simulate work
                    System.out.println("Task " + id + " completed.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();  // WAIT for all tasks to finish
        System.out.println("All tasks completed. Continue main process...");

        executorService.shutdown();

    }
}
