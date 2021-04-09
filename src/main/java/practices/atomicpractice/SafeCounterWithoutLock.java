package practices.atomicpractice;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCounterWithoutLock {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getValue() {
        return counter.get();
    }

    public void increment() {
        while (true){
            int existValue = getValue();
            int newValue = existValue + 1;
            if (counter.compareAndSet(existValue, newValue)){
                return;
            }
        }
    }
}
