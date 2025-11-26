package java_interview.thread.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
    A BlockingQueue is a thread-safe queue where:
    ✔ put() : Inserts an item and Blocks (waits) if the queue is full
    ✔ take() : Removes and returns an item. It Blocks (waits) if the queue is empty

    So producer stops when queue is full; consumer waits when queue is empty.
    This avoids manual wait/notify and simplifies synchronization.
 */
public class ProducerConsumer {
    // BlockingQueue automatically handles synchronization between producer and consumer.
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        /*
        Produces an increasing integer every 500ms , Uses queue.put(), which:
        Inserts the value, If queue already contains 5 elements → producer waits until space becomes available
         */
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    System.out.println("Produced: " + value);
                    queue.put(value++);
//                    Thread.sleep(500);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        /*
            Consumes one number every 1000ms, Uses queue.take(), which Removes the head of the queue
            If queue is empty → consumer waits until producer puts something in
         */
        Runnable consumer = () -> {
            try {
                while (true) {
                    Integer take = queue.take();
                    System.out.println("Consumed: " + take);
//                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

/*Note : With Thread.sleep() added, both producer and consumer run in parallel, regardless of the queue size.
 without sleep, new ArrayBlockingQueue<>(5) means: The queue can hold only 5 items at a time.
    If a 6th item is added, producer thread blocks. When the consumer removes an item, space frees up.
 */

/*
Thread.sleep() is not required for the producer–consumer mechanism to work.

It is included only to:

✔ slow down producer
✔ slow down consumer
✔ visually show output step-by-step
✔ demonstrate blocking behavior

So why do we use sleep() in example code?
    Just to simulate real-world delays:
    ✔ Producer taking time to produce an item : (e.g., reading file, generating data, doing calculations)
    ✔ Consumer taking time to process an item : (e.g., writing to DB, saving to disk, doing heavy work)
    ✔ To show output slowly
 */
