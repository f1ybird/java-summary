package multhread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 测试AtomicInteger
 * @Author: zhangkai
 * @Date: 2020/3/21 23:02
 */
public class AtomicIntegerTest {

    private AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        AtomicIntegerTest test = new AtomicIntegerTest();
        System.out.println(test.get());
        test.increment();
        System.out.println(test.get());
    }

    public int increment() {
        return count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }

}
