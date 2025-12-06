package java_interview.thread.ReentrantLock.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        int threads = 5;
        ExecutorService pool = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            String user = "User-" + i;
            pool.execute(() -> {
                account.withdraw(300, user);
            });
        }

        pool.shutdown();
    }
}
