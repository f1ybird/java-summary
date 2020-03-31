package multhread.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description: 验证ABA问题解决方案：CAS通过新增版本号的机制来解决。在这里可以使用 AtomicStampedReference 来解决。
 * @Author: zhangkai
 * @Date: 2020/3/9 0:11
 */
public class SolveABADemo {

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 版本号：" + stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 版本号：" + atomicStampedReference.getStamp());
        }, "t1").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 版本号：" + stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean ret = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + ret
                    + " stamp:" + atomicStampedReference.getStamp()
                    + " value:" + atomicStampedReference.getReference());
        }, "t2").start();
    }

}
