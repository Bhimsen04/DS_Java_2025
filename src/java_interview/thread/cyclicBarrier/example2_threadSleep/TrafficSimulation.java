package java_interview.thread.cyclicBarrier.example2_threadSleep;

import java.util.concurrent.CyclicBarrier;

public class TrafficSimulation {

    private static final int NUM_CARS = 5;
    private static CyclicBarrier barrier = new CyclicBarrier(NUM_CARS, new Runnable(){
        public void run(){
            System.out.println("All cars reached the checkpoint. Proceed!");
        }
    });

    public static void main(String[] args) {
        for (int i = 0; i < NUM_CARS; i++) {
            new Thread(new Car(barrier)).start();
        }
    }
}
