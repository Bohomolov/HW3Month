package practices.atomicpractice;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SequenceGenerator {
    private static BigInteger MULTIPLAYER;
    private AtomicReference<BigInteger> element;

    public SequenceGenerator() {
        if (MULTIPLAYER == null) {
            MULTIPLAYER = BigInteger.valueOf(2);
        }
        element = new AtomicReference<>(BigInteger.ONE);
    }

    BigInteger next() {
        BigInteger value;
        BigInteger next;
        do {
            value = element.get();
            next = value.multiply(MULTIPLAYER);
        } while (!element.compareAndSet(value, next));
        return value;
    }
}
