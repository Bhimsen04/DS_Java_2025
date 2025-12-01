package java_interview.thread.cyclicBarrier.example2_realtime;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private String name;
    private int speed;  // Speed in km/h
    private CyclicBarrier barrier;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.barrier = TrafficSimulationEx.barrier;
    }

    @Override
    public void run() {
        try {
            // Simulate the time it takes for each car to reach the checkpoint based on its speed
            double distance = 10.0; // Let's assume the checkpoint is 10 km away.
            double timeToReach = distance / speed; // Time = Distance / Speed in hours
            long timeToReachInMillis = (long) (timeToReach * 60 * 60 * 1000); // Convert to milliseconds

            System.out.println(name + " is driving to the checkpoint at " + speed + " km/h.");

            // Wait for the calculated time (using a delay to simulate travel time)
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < timeToReachInMillis) {
                // Simulate the car driving for the calculated time without using Thread.sleep
//                System.out.println(Thread.currentThread().getName() + " Car " + name);
//                System.out.println(System.currentTimeMillis() - startTime);
//                System.out.println(timeToReachInMillis);
            }

            System.out.println(name + " reached the checkpoint.");
            barrier.await();  // Wait for other cars at the checkpoint
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
