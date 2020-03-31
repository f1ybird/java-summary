package multhread.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 使用阻塞队列实现生产者消费者模式，方案1-使用lock
 * @Author: zhangkai
 * @Date: 2020/3/9 23:36
 */
class ShareData {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + " produce\t" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //判断
            while (number == 0) {
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + " consume\t" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 一个初始值为0的变量，两个线程交替操作，一个加1一个减1,重复5次
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒机制:判断的时候要用while而不是用if
 */
public class ProduceConsumeTraditionalDemo {

    public static void main(String[] args) {

        ShareData data = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}
