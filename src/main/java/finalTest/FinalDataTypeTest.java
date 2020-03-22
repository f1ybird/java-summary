package finalTest;

public class FinalDataTypeTest {

    public static void main(String[] args) {

        byte b1 = 1;
        byte b2 = 2;
        //这里编译器会提示错误 Required type byte Provided int
        //byte b = b1 + b2;
        //b2和b2相加，虚拟机会转为int执行，所以不能把int类型赋值给byte，解决方法如下：
        //法1：直接强转
        byte b = (byte) (b1 + b2);
        System.out.println(b);

        //法2：将b2和b2用final修饰，让类型不可变
        final byte b11 = 1;
        final byte b22 = 2;
        byte bb = b11 + b22;
        System.out.println(bb);
    }
}
