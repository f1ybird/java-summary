package interview;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 * @Author: zhangkai
 * @Date: 2020/3/22 17:20
 */
public class Test01 {

    List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                if (test01.size() != 5) {
                    try {
                        //释放锁
                        lock.wait();
                        System.out.println("t2结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1启动");
                for (int i = 0; i < 10; i++) {
                    test01.add(i);
                    System.out.println("添加" + i);
                    if (test01.size() == 5) {
                        /**不会释放锁*/
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1").start();
    }
}
