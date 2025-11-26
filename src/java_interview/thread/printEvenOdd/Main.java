package java_interview.thread.printEvenOdd;

public class Main {
    public static void main(String[] args) {

        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter();
        Thread t1 = new Thread(oddEvenPrinter::printOdd);
        Thread t2 = new Thread(oddEvenPrinter::printEven);
        t1.start();
        t2.start();
    }
}
