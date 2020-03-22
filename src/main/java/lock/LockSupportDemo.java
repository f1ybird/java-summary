package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description: 使用park/unpark实现线程同步
 * @Author: zhangkai
 * @Date: 2020/3/22 22:25
 */
public class LockSupportDemo extends Thread {

    private Object object;

    public LockSupportDemo(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("blocker info1: " + LockSupport.getBlocker((Thread) object));
            LockSupport.unpark((Thread) object);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("blocker info2: " + LockSupport.getBlocker((Thread) object));
            System.out.println("after unpark");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LockSupportDemo lockSupportDemo = new LockSupportDemo(Thread.currentThread());
        lockSupportDemo.start();
        System.out.println("before park");
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
