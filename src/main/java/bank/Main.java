package bank;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Lock lock = new ReentrantLock();
        int count = 0;
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(10_000, threadFactory);
        while (count < 10_000) {
            try {
                lock.lock();
                Client client = new Client(bank);
                Condition condition = lock.newCondition();
                executorService.execute(threadFactory.newThread(client));
                condition.await(10, TimeUnit.MILLISECONDS);
                count++;
            } finally {
                lock.unlock();
            }
        }
    }
}