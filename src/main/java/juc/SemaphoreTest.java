package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Semaphore(信号量)-允许多个线程同时访问
 * @Author: zhangkai
 * @Date: 2020/3/22 0:32
 */
public class SemaphoreTest {

    // 请求的数量
    private static final int THREAD_COUNT = 100;
    //核心线程池大小
    private static final int CORE_POOL_SIZE = 5;
    //最大线程池大小
    private static final int MAX_POOL_SIZE = 10;
    //阻塞队列大小
    private static final int QUEUE_CAPACITY = 1000;
    //最大线程池存活时间
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(20);
        //自定义线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadnum = i;
            executor.execute(() -> {
                try {
                    //获取一个许可，所以可运行线程数量为20/1=20
                    semaphore.acquire();
                    test(threadnum);
                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) ;

        System.out.println("Finished all threads");

    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(200);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(200);// 模拟请求的耗时操作
    }
}
