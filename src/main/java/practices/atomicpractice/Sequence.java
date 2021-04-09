package practices.atomicpractice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Sequence implements Runnable {
    Thread thread;
    private int count;
    private int id;
    private SequenceGenerator sg;
    private List<BigInteger> sequence = new ArrayList<>();
    private boolean printed = false;

    public Sequence(int id, int count, SequenceGenerator sg) {
        this.id = id;
        this.count = count;
        this.sg = sg;
        thread = new Thread(this);

        System.out.println("Thread created " + id);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                sequence.add(sg.next());
                Thread.sleep((long) ((Math.random() * 2 + 1) * 30));
            }

        } catch (InterruptedException e) {
            System.out.println("Thread " + id + " interrupt");
        }
        System.out.println("Thread " + id + " finished");
        printSequence();
    }

    void printSequence() {
        if (printed) {
            return;
        }
        StringBuilder tmp = new StringBuilder(" [");

        for (int i = 0; i < sequence.size(); i++) {
            if (i > 0) {
                tmp.append(",");
            }
            StringBuilder nb = new StringBuilder(String.valueOf(sequence.get(i)));
            while (nb.length() < 9) {
                nb.insert(0, " ");
            }
            tmp.append(nb);
        }
        tmp.append("] ");
        System.out.println("Sequence thread " + id + " : " + tmp);
        printed = true;
    }
}
