package interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: semaphore初始化有2个令牌，一个线程调用1次release方法，然后一次性获取3个令牌，会获取到吗?
 *
 * availablePermits:2,semaphore.tryAcquire(3,1, TimeUnit.SECONDS):false
 * availablePermits:3,semaphore.tryAcquire(3,1, TimeUnit.SECONDS):true
 *
 * @Author: zhangkai
 * @Date: 2020/3/22 17:54
 */
public class TestSemaphore2 {

    public static void main(String[] args) {

        int permitsNum = 2;
        final Semaphore semaphore = new Semaphore(permitsNum);
        try {
            System.out.println("availablePermits:" + semaphore.availablePermits() + ",semaphore.tryAcquire(3,1, TimeUnit.SECONDS):" + semaphore.tryAcquire(3, 1, TimeUnit.SECONDS));
            semaphore.release();
            System.out.println("availablePermits:" + semaphore.availablePermits() + ",semaphore.tryAcquire(3,1, TimeUnit.SECONDS):" + semaphore.tryAcquire(3, 1, TimeUnit.SECONDS));
        } catch (Exception e) {

        }

    }
}