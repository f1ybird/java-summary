package programtest.hongpusen;

/**
 * @Description: 鸿普森-静态方法不能直接调用非静态方法
 * @Author: zhangkai
 * @Date: 2020/5/16 23:49
 */
public class StaticTest {

    /**
     * 原题目：有报错
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Hello h = new Hello();
//        h.print();
//    }
    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        staticTest.getData();
    }

    public void getData() {
        Hello h = new Hello();
        h.print();
    }

    private class Hello {

        private String name = "hello";

        public String getName() {
            return name;
        }

        public void print() {
            System.out.println(name);
        }
    }

}

