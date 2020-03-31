package multhread.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 自定义ThreadPoolExecutor
 * @Author: zhangkai
 * @Date: 2020/3/21 19:05
 */
public class ThreadPoollExecutorDemo {

    //核心线程池大小
    private static final int CORE_POOL_SIZE = 5;
    //最大线程池大小
    private static final int MAX_POOL_SIZE = 10;
    //阻塞队列大小
    private static final int QUEUE_CAPACITY = 1000;
    //最大线程池存活时间
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //自定义ThreadPoolExecutor线程池，如果加入队列的任务超过队列容量，则由当前的main线程执行了
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new MyRunnableTest("" + i));
        }

        threadPoolExecutor.shutdown();

        while (!threadPoolExecutor.isTerminated()) ;

        System.out.println("Finished all threads");

    }
}
