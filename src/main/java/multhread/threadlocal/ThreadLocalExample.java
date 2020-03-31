package multhread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试ThreadLocal
 * 0:yyyy-MM-dd
 * 1:yyyy-MM-dd
 * 0:yy-M-d ah:mm
 * 2:yyyy-MM-dd
 * 1:yy-M-d ah:mm
 * 3:yyyy-MM-dd
 * 2:yy-M-d ah:mm
 * 3:yy-M-d ah:mm
 * 4:yyyy-MM-dd
 * 4:yy-M-d ah:mm
 * <p>
 * 每个线程第一次执行的结果都是一致的，说明每个线程都获取到了自己线程本地的threadLocal值
 * @Author: zhangkai
 * @Date: 2020/3/19 23:55
 */
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(example, "" + i);
            TimeUnit.SECONDS.sleep(1);
            thread.start();
        }

        //手动清理，防止key为null后因为是弱引用weakReference被自动回收，value无法回收造成内存泄漏
        threadLocal.remove();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().toPattern());

        threadLocal.set(new SimpleDateFormat());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().toPattern());

    }
}
