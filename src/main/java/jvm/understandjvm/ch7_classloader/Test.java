package jvm.understandjvm.ch7_classloader;

/**
 * @Description: 由于父类的<clinit>()方法先执行， 也就意味着父类中定义的静态语句块
 * 要优先于子类的变量赋值操作， 如下面的测试代码，字段B的值将会是2而不是1。
 * @Author: zhangkai
 * @Date: 2020/4/7 23:22
 */
public class Test {

    static class Parent {

        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        //猜猜B会是多少？
        System.out.println(Sub.B);//2
    }
}
