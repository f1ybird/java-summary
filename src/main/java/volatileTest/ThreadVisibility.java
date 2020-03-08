package volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 验证：volatile的线程可见性
 * @Author: zhangkai
 * @Date: 2020/3/8 17:20
 */
public class ThreadVisibility {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
                //do sth
            }
            System.out.println("end");
        }, "server").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
    }
}
