package jvm.gc;

/**
 * @Description: JVM内存分配担保机制测试，参考：https://cloud.tencent.com/developer/article/1082730
 * @Author: zhangkai
 * @Date: 2020/4/1 22:55
 */
public class HandlePromotionFailure {

    private static final int _1MB = 1024 * 1024;

    public static void testHandlePromotion() {

        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * JVM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * <p>
     * 初始化内存20M，
     * 最大20M，
     * 分配给年轻代10M，
     * 打印GC细节，
     * 设置分配新生代各区的比例，设置为8，表示eden与一个survivor区的空间比例为8:1，
     * 指定垃圾收集器为客户端模式下的Serial+Serial Old的收集器组合进行内存回收
     *
     * @param args
     */
    public static void main0(String[] args) {
        testHandlePromotion();
    }

    /**
     * JVM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParallelGC
     * <p>
     * 初始化内存20M，
     * 最大20M，
     * 分配给年轻代10M，
     * 打印GC细节，
     * 设置分配新生代各区的比例，设置为8，表示eden与一个survivor区的空间比例为8:1，
     * 指定垃圾收集器为客户端模式下的Parallel Scavenge+Parallel Old的收集器组合进行内存回收
     *
     * @param args
     */
    public static void main(String[] args) {
        testHandlePromotion();
    }
}
