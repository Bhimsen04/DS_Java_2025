package java_interview.thread.countDownLatch.example1;

import java.util.concurrent.CountDownLatch;

public class AppInitializer {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Thread cacheLoader = new Thread(() -> {
            loadcache();
            latch.countDown();
        });

        Thread dbLoader = new Thread(() -> {
            initDB();
            latch.countDown();
        });

        Thread configLoader = new Thread(() -> {
            loadConfig();
            latch.countDown();
        });
        cacheLoader.start();
        dbLoader.start();
        configLoader.start();
        latch.await(); // Wait till all initializers are done
        System.out.println("All initializations done. Starting main service...");

    }

    private static void loadConfig() {
        System.out.println("Loading config...");
    }

    private static void initDB() {
        System.out.println("Initializing DB...");
    }

    private static void loadcache() {
        System.out.println("Loading CACHE...");
    }
}
