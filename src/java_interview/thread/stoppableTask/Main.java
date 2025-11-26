package java_interview.thread.stoppableTask;

/*
Thread runs a loop until someone requests it to stop.
Main thread waits 5 seconds and then sends a stop request using interrupt().
Worker thread checks this request using isInterrupted() and stops itself.
If the thread is sleeping when interrupted, it wakes up with an exception, resets the flag, and stops.
That's why again sets in catch block
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new StoppableTask());
        t.start();

        // main thread waits 5 seconds
        Thread.sleep(5000);

        // main thread requests the worker thread to stop ,
        // this sets interrupted = true
        // Before t.interrupt() : isInterrupted() = false → loop runs
        // After t.interrupt() : isInterrupted() = true → loop stops
        t.interrupt();
    }
}
