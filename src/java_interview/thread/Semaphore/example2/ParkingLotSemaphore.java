package java_interview.thread.Semaphore.example2;

import java.util.concurrent.*;

public class ParkingLotSemaphore {

    private static final int PARKING_SLOTS = 2;
    private static Semaphore semaphore = new Semaphore(PARKING_SLOTS);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            String carName = "Car " + i;

            executor.submit(() -> {
                try {
                    System.out.println(carName + " wants to park...");

                    semaphore.acquire(); // waits only if no slot available
                    System.out.println(carName + " parked.");

                    // Simulate REAL WORK instead of sleep
                    CompletableFuture.runAsync(() -> {
                        busyWork(carName);
                    }).thenRun(() -> {
                        System.out.println(carName + " leaving...");
                        semaphore.release();
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    // Real-time work (CPU load), not Thread.sleep
    private static void busyWork(String carName) {
        System.out.println(carName + " is doing real work inside parking...");
        double result = 0;
        for (int i = 0; i < 5_000_000; i++) {
            result += Math.sqrt(i);
        }
        System.out.println(carName + " work finished.");
    }
}

