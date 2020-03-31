package multhread.finalTest;

/**
 * @Description: 当声明一个 final 成员时，必须在构造函数退出前设置它的值。
 * @Author: zhangkai
 * @Date: 2020/3/22 15:35
 */
public class FinalReferenceEscapeDemo {

    private final int a;
    private FinalReferenceEscapeDemo referenceDemo;

    public FinalReferenceEscapeDemo() {
        a = 1;  //1
        referenceDemo = this; //2  当前引用溢出，由于重排序，2在1之前执行，可能导致reader到的a=0
    }

    public void writer() {
        new FinalReferenceEscapeDemo();
    }

    public void reader() {
        if (referenceDemo != null) {  //3
            int temp = referenceDemo.a; //4
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        FinalReferenceEscapeDemo demo = new FinalReferenceEscapeDemo();

        Thread athread = new Thread(() -> demo.writer(), "A");
        athread.start();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> demo.reader(), "B" + i).start();
        }
    }
}