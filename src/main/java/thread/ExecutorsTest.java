package thread;

import java.util.concurrent.*;

/**
 * @Description: 测试线程池工具类
 * @Author: zhangkai
 * @Date: 2020/3/21 18:21
 */
public class ExecutorsTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //execute直接执行异步任务
        //executorService.execute(new MyRunnable());

        //submit可以拿到返回结果
        Future<?> futureResult = executorService.submit(new MyCallable());
        System.out.println(futureResult.get(3, TimeUnit.SECONDS));
        executorService.shutdown();

        System.out.println(Thread.currentThread().getName() + "=run");
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "= Runnable");
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "= Callable");
        return "SUCCESS";
    }
}