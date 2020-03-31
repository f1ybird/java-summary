package multhread.volatileTest;

class MyData {
    volatile int number = 0;

    public void addOne() {
        number++;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        case2();
    }

    //验证原子性
    public static void case2() {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addOne();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t number value:" + myData.number);
    }
}