package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

    private static final AtomicInteger nextId = generateNextId();

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static int get() {
        return threadId.get();
    }

    public static AtomicInteger generateNextId() {
        System.out.println("generate Next id called!");
        return new AtomicInteger(0);
    }

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Thread id: " + ThreadLocalExample.get());

        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }

        System.out.println("Ended!");
    }
}
