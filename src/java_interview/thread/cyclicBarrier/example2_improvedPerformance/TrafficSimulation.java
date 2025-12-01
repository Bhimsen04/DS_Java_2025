package java_interview.thread.cyclicBarrier.example2_improvedPerformance;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSimulation {
    private static final int NUM_CARS = 5; // Total number of cars
    static CyclicBarrier barrier = new CyclicBarrier(NUM_CARS, new Runnable() {
        @Override
        public void run() {
            System.out.println("All cars reached the checkpoint. Proceed!");
        }
    });

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Car A", 100),  // Car A, speed 100 km/h
                new Car("Car B", 80),   // Car B, speed 80 km/h
                new Car("Car C", 120),  // Car C, speed 120 km/h
                new Car("Car D", 90),   // Car D, speed 90 km/h
                new Car("Car E", 110)   // Car E, speed 110 km/h
        };

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_CARS);

        // Schedule each car to reach the checkpoint based on its speed
        for (Car car : cars) {
            long delay = calculateDelay(car.getSpeed());

            // After delay e.g 20 mins, executorService will automatically the run method of Car Object.
            executorService.schedule(car, delay, TimeUnit.MILLISECONDS);
        }

        // Shutdown the executor service after the tasks have been scheduled
        executorService.shutdown();

        System.out.println("Main thread not blocks");
        for (int i = 0; i < NUM_CARS; i++) {
            System.out.println(cars[i]);
        }
    }

    private static long calculateDelay(int speed) {
        // Assume the checkpoint is 10 km away
        double distance = 10.0; // Distance in kilometers
        double timeInHours = distance / speed; // Time in hours
        return (long) (timeInHours * 60 * 60 * 1000); // Convert hours to milliseconds
    }
}

