package java_interview.thread.cyclicBarrier.example2_improvedPerformance;

import java.util.concurrent.CyclicBarrier;

class Car implements Runnable {
    private String name;
    private int speed;  // Speed in km/h
    private CyclicBarrier barrier;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.barrier = TrafficSimulation.barrier;
    }

    @Override
    public void run() {
        try {
            // Car is "driving" to the checkpoint, and after the delay, it will reach the checkpoint
            System.out.println(name + " is driving to the checkpoint at " + speed + " km/h.");

            // Wait until the calculated delay time (this is handled by the scheduled task)
            System.out.println(name + " reached the checkpoint.");
            barrier.await();  // Wait for other cars at the checkpoint
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSpeed() {
        return speed;
    }
}
