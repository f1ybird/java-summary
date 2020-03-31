package multhread.juc;

import java.util.concurrent.*;

/**
 * @Description: CyclicBarrier(循环栅栏)
 * <p>
 * CyclicBarrier 可以用于多线程计算数据，最后合并计算结果的应用场景。
 * 比如我们用一个Excel保存了用户所有银行流水，每个Sheet保存一个帐户近一年的每笔银行流水，
 * 现在需要统计用户的日均银行流水，先用多线程处理每个sheet里的银行流水，都执行完之后，
 * 得到每个sheet的日均银行流水，最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水。
 * </p>
 * @Author: zhangkai
 * @Date: 2020/3/22 0:52
 */
public class CyclicBarrierTest {

    // 请求的数量
    private static final int THREAD_COUNT = 10;
    //核心线程池大小
    private static final int CORE_POOL_SIZE = 5;
    //最大线程池大小
    private static final int MAX_POOL_SIZE = 10;
    //阻塞队列大小
    private static final int QUEUE_CAPACITY = 1000;
    //最大线程池存活时间
    private static final Long KEEP_ALIVE_TIME = 1L;
    //栅栏数量
    private static final int PARTIES_COUNT = 5;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTIES_COUNT, () -> System.out.println("到达屏障后，优先执行此方法"));

    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < THREAD_COUNT; i++) {
            int threadnum = i;
            executor.execute(() -> test(threadnum));
        }

        executor.shutdown();
        while (!executor.isTerminated()) ;

        System.out.println("Finished all threads");

    }

    public static void test(int threadnum) {
        System.out.println("threadnum:" + threadnum + "is ready");
        try {
            cyclicBarrier.await(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + "is finish");
    }
}
