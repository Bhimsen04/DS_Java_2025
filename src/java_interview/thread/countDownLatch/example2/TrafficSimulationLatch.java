package java_interview.thread.countDownLatch.example2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
    ➡ Each car has a delay based on its speed.
    ➡ Faster cars arrive (print message) earlier.
    ➡ Each arrival decreases the latch count by 1.
    ➡ The main thread waits until the latch reaches zero.
    ➡ When all cars have arrived, the program prints:
 */
public class TrafficSimulationLatch {
    private static final int NUM_CARS = 5; // Total number of cars
    private static CountDownLatch latch = new CountDownLatch(NUM_CARS);

    public static void main(String[] args) {
        // Create Car objects
        Car[] cars = {
                new Car("Car A", 100),
                new Car("Car B", 80),
                new Car("Car C", 120),
                new Car("Car D", 90),
                new Car("Car E", 110)
        };

        // Scheduled executor to simulate travel delays
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_CARS);

        // Schedule each car based on its speed
        for (Car car : cars) {
            long delay = calculateDelay(car.getSpeed());
            executorService.schedule(() -> {
                car.drive();         // car reaches checkpoint
                latch.countDown();   // signal arrival
            }, delay, TimeUnit.MILLISECONDS);
        }

        // Main thread waits until all cars reach the checkpoint
        try {
            latch.await(); // Main thread waits for all cars
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello");
            }
            System.out.println("All cars reached the checkpoint. Proceed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    // Convert speed to delay for checkpoint arrival
    private static long calculateDelay(int speed) {
        double distance = 10.0; // 10 km to checkpoint
        double timeInHours = distance / speed;
        return (long) (timeInHours * 60 * 60 * 1000); // convert hours to milliseconds
    }
}