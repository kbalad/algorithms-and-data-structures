package multithreading;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.*;

import static java.lang.System.exit;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        UnsafeSequence object = new UnsafeSequence();
        Set<Integer> used = Collections.synchronizedSet(new HashSet<>());

        Runnable r = () -> {
            int cnt = 0;
            while(cnt++ < 100_000_000) {
                int v = object.getNext();
                System.out.println(v);
                if (used.contains(v)) {
                    System.err.println("Already used " + v);
                    exit(1);
                } else {
                    used.add(v);
                }
            }
        };

        int k = 3;
        Thread[] ts = new Thread[k];
        for (int i = 0; i < k; i++) {
            ts[i] = new Thread(r);
        }

        Arrays.stream(ts).forEach(Thread::start);
    }
}
