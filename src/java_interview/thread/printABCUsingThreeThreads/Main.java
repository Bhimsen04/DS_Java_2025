package java_interview.thread.printABCUsingThreeThreads;

/*
  Even though A, B, and C are different methods, they all use the same ReentrantLock,
    so only one of them can run the locked part at a time
    — the rest must wait until the lock is released.

    🔐 “ReentrantLock is a mutual exclusion lock (mutex)” means:
    👉 Only ONE thread can hold the lock at a time
    👉 If another thread tries to get the same lock, it must wait
    👉 This prevents two threads from entering the critical section together
    👉 This ensures safe access to shared data

 */
public class Main {
    public static void main(String[] args) {
        ABCPrinter printer = new ABCPrinter();
        new Thread(printer::printA).start();
        new Thread(printer::printB).start();
        new Thread(printer::printC).start();
    }
}
