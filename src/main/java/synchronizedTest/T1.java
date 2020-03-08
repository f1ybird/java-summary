package synchronizedTest;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 验证：能否在多线程同时调用同步和非同步方法
 * @Author: zhangkai
 * @Date: 2020/3/8 15:04
 */
public class T1 {

    /**
     * m1加锁
     */
    public synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    /**
     * m2不加锁
     */
    public void m2() {
        System.out.println("m2 start");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread(t1::m1, "m1").start();
        new Thread(t1::m2, "m2").start();
    }
}