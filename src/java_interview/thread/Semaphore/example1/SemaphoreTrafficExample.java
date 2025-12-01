package java_interview.thread.Semaphore.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTrafficExample {
    private static final int NUM_CARS = 5;
    private static final Semaphore bridge = new Semaphore(2); // only 2 cars allowed on the bridge

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_CARS);

        Car[] cars = {
                new Car("Car A"),
                new Car("Car B"),
                new Car("Car C"),
                new Car("Car D"),
                new Car("Car E")
        };

        for (Car car : cars) {
            executor.submit(() -> {
                try {
                    System.out.println(car.getName() + " is waiting to enter bridge...");

                    bridge.acquire(); // acquire permission
                    System.out.println(car.getName() + " ENTERED the bridge.");

                    Thread.sleep(2000); // simulate time to cross

                    System.out.println(car.getName() + " EXITED the bridge.");
                    bridge.release(); // release permission

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
