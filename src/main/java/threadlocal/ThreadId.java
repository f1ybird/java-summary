package threadlocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId implements Runnable {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    public static void main(String[] args) throws InterruptedException {
        ThreadId threadId = new ThreadId();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadId, "" + i);
            TimeUnit.SECONDS.sleep(1);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + threadId.get());
    }
}