package java_interview.thread.ReentrantLock.example1;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private ReentrantLock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount, String user) {
        lock.lock();   // acquire lock
        try {
            System.out.println(user + " checking balance...");

            if (balance >= amount) {
                System.out.println(user + " is withdrawing " + amount);

                // real-time “work” like calculations, DB logic, etc.
                doComplexCalculation();

                balance -= amount;

                System.out.println(user + " completed withdrawal. New balance = " + balance);
            } else {
                System.out.println(user + " cannot withdraw. Insufficient balance!");
            }
        } finally {
            lock.unlock();  // always release lock
        }
    }

    // real CPU work—not sleep
    private void doComplexCalculation() {
        for (int i = 0; i < 1_000_00; i++) {
            Math.sqrt(i);
        }
    }

}
