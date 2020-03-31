package multhread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description: wait和notify实现线程同步
 * <p>
 * before wait
 * before notify
 * after notify
 * after wait
 * </p>
 * @Author: zhangkai
 * @Date: 2020/3/22 22:14
 */
public class ThreadTransitionDemo extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTransitionDemo myThread = new ThreadTransitionDemo();
        synchronized (myThread) {
            try {
                myThread.start();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("before wait");
                //释放锁
                myThread.wait();
                System.out.println("after wait");
            } catch (Exception e) {

            }
        }
    }
}
