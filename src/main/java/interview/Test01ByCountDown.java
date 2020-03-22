package interview;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 * @Author: zhangkai
 * @Date: 2020/3/22 17:20
 */
public class Test01ByCountDown {

    List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Test01ByCountDown test01 = new Test01ByCountDown();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2启动");
            if (test01.size() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2结束");
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                test01.add(i);
                System.out.println("添加" + i);
                if (test01.size() == 5) {
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                }
            }
        }, "t1").start();
    }
}
