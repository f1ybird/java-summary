package lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: 线程通信：使用LockSupport依次打印 “1A2B3C4D5E6F”
 * @Author: zhangkai
 * @Date: 2020/3/12 21:11
 */
public class ThreadCommLockSupport {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        char[] aI = "123456".toCharArray();
        char[] aC = "ABCDEF".toCharArray();

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t1.start();
        t2.start();


    }

}
