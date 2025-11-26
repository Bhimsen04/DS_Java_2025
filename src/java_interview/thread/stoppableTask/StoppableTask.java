package java_interview.thread.stoppableTask;

public class StoppableTask implements Runnable {


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Doing his work");
            try {
                // If the thread is interrupted while sleeping,
                // Java throws InterruptedException.
                // then restores the interrupt flag that Java cleared automatically.
                // means this sets interrupted = false
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Stopped!");
    }
}
