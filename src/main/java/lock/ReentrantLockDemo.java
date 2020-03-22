package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: ReentrantLock的fair锁测试
 * @Author: zhangkai
 * @Date: 2020/3/22 22:56
 */
public class ReentrantLockDemo extends Thread {

    private Lock lock;

    public ReentrantLockDemo(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //公平锁
        Lock lock = new ReentrantLock(true);

        ReentrantLockDemo t1 = new ReentrantLockDemo("t1", lock);
        ReentrantLockDemo t2 = new ReentrantLockDemo("t2", lock);
        ReentrantLockDemo t3 = new ReentrantLockDemo("t3", lock);

        t1.start();
        t2.start();
        t3.start();
    }
}