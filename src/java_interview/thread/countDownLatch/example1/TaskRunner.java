package java_interview.thread.countDownLatch.example1;

import java.util.concurrent.*;

public class TaskRunner {

    /*
        It starts 10 threads
        Each thread prints "Thread: X" and then calls latch.countDown()
        The main thread waits at latch.await()
        After all 10 threads have finished, the main thread prints: All threads finished!
     */
    /*This is a classic example of using CountDownLatch to make the main thread wait for multiple threads to finish.*/

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(10); // The latch will “open” only after countDown() has been called 10 times.

        for (int i = 0; i < 10; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Thread: " + id);
                latch.countDown();
            }).start();
        }

        /* wait for all ( Main thread will wait until the count reaches 0 )
        It does not continue until all 10 threads complete their work */

        latch.await();
        System.out.println("All threads finished!");
    }
}

/* Real time example :
    Load configuration files concurrently → wait before starting the service

    Let multiple modules initialize → wait for all

    Perform batch processing in parallel then merge results
 */

