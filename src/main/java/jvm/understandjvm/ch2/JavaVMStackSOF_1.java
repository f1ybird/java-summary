package jvm.understandjvm.ch2;


/**
 * @Description: 虚拟机栈和本地方法栈溢出，使用-Xss参数减少栈内存容量
 * VM Args：-Xss128k
 * @Author: zhangkai
 * @Date: 2020/4/5 15:48
 */
public class JavaVMStackSOF_1 {

    private int stackLength = 1;

    public void setStackLength() {
        stackLength++;
        setStackLength();
    }

    public static void main(String[] args) {
        JavaVMStackSOF_1 oom = new JavaVMStackSOF_1();
        try {
            oom.setStackLength();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
