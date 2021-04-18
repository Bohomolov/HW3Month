package practices.cryptography;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Executor executor = (runnable) -> new Thread(runnable).start();
        Runnable runnable1 = () ->{
        };

        executor.execute(runnable1);
    }

    public static int getFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return number < 2 ? 1 : getFactorial(number - 1) * number;
    }

    public static int getFibonacci(int number) {
        if (number < 0) {
            return number == -1 ? number : getFibonacci(number + 2) + getFibonacci(number + 1);
        }
        return number == 1 || number == 0 ? number : getFibonacci(number - 1) + getFibonacci(number - 2);
    }

}