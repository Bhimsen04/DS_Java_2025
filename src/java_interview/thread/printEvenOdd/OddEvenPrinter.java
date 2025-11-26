package java_interview.thread.printEvenOdd;

public class OddEvenPrinter {
    private int number = 1;
    private final int limit = 10;
    private final Object lock = new Object();

    public void printOdd() {
        synchronized (lock) {
            while (number < limit) {
                if (number % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Odd :- " + number);
                number++;
                lock.notify();
            }
        }
    }


    public void printEven() {
        synchronized (lock) {
            while (number < limit) {
                if (number % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even :- " + number);
                number++;
                lock.notify();
            }
        }
    }
}
