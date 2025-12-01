package java_interview.thread.countDownLatch.example1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiPhaseTask {

    public static void main(String[] args) throws InterruptedException {
        int workers = 5;

        CountDownLatch phase1 = new CountDownLatch(workers);
        CountDownLatch phase2 = new CountDownLatch(workers);
        CountDownLatch phase3 = new CountDownLatch(workers);

        ExecutorService service = Executors.newFixedThreadPool(16);

        for (int i = 0; i < workers; i++) {

            int id = i;
            service.execute(() -> {

                // phase 1
                System.out.println("Worker " + id + " loading data...");
                sleep(10);
                phase1.countDown();

                // Wait for others to finish phase 1
                await(phase1);

                // Phase 2
                System.out.println("Worker " + id + " processing data...");
                sleep(10);
                phase2.countDown();

                await(phase2);

                // Phase 3
                System.out.println("Worker " + id + " saving results...");
                sleep(10);
                phase3.countDown();
            });
        }

        phase3.await(); // main waits for all workers to finish phase 3
        System.out.println("All phases complete!");

        service.shutdown();


    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {
        }
    }

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (Exception ignored) {
        }
    }

    /*  Output :
        Worker 0 loading data...
        Worker 3 loading data...
        Worker 4 loading data...
        Worker 2 loading data...
        Worker 1 loading data...
        Worker 3 processing data...
        Worker 0 processing data...
        Worker 1 processing data...
        Worker 4 processing data...
        Worker 2 processing data...
        Worker 2 saving results...
        Worker 0 saving results...
        Worker 4 saving results...
        Worker 1 saving results...
        Worker 3 saving results...
        All phases complete!
     */
    /*
        ✔ Phase 2 will NOT execute until Phase 1 is fully completed by all threads
        ✔ Phase 3 will NOT execute until Phase 2 is fully completed by all threads
     */

    /* Failures

        Final Summary
        ❌ newFixedThreadPool(1) fails

        Because:

        Tasks 2 and 3 cannot run

        Because:

        There is only 1 thread in the pool

        That thread is stuck in await()

        No free thread remains

        So Task 2 and Task 3 never get CPU time

        Latch count remains 2 forever.

        → DEADLOCK

        ✔ You need at least “workers” number of threads ( thread >= wokers)

        newFixedThreadPool(workers)
        so each worker thread runs concurrently.

     */

    /*
    ✅ Takeaway

        CountDownLatch requires enough threads to let all workers reach countDown()

        With 3 workers, you need at least 3 threads to avoid deadlock

        You cannot have 1 thread do all phases “by itself” if the latch is counting for multiple workers
     */
}
