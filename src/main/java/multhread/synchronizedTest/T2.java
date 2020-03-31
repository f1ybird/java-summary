package multhread.synchronizedTest;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 验证：synchronized是不是可重入锁
 * @Author: zhangkai
 * @Date: 2020/3/8 15:04
 */
public class T2 {

    /**
     * m1加锁
     */
    public synchronized void m1() {
        System.out.println("m1");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    /**
     * m2加锁
     */
    public synchronized void m2() {
        System.out.println("m2");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new T2().m1();
    }
}