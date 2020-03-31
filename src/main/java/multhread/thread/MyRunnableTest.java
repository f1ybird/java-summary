package multhread.thread;

import java.util.Date;

/**
 * 这是⼀个简单的Runnable类，需要⼤约5秒钟来执⾏其任务。
 *
 * @author shuang.kou
 */
public class MyRunnableTest implements Runnable {

    private String command;

    public MyRunnableTest(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time =" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = "+ new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}