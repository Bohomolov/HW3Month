package practices.atomicpractice;

import java.util.ArrayList;
import java.util.List;

public class SequenceGeneratorExample {
    public static void main(String[] args) {
        SequenceGenerator sg = new SequenceGenerator();
        List<Sequence> sequences = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sequence seq = new Sequence(i + 1, 3, sg);
            sequences.add(seq);
        }
        System.out.println("\nCalculate sequences\n");
        int sum;
        do {
            sum = 0;
            for (Sequence s : sequences) {
                if (!s.thread.isAlive()) {
                    s.printSequence();
                    sum++;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        } while (sum < sequences.size());
        System.out.println("\n\nThread process is over...");
        System.exit(0);
    }

}
