package jvm.understandjvm.ch3_gc;

/**
 * @Description: 大对象直接进入老年代
 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @Author: zhangkai
 * @Date: 2020/4/6 16:46
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        //会直接分配在老年代
        allocation = new byte[4 * _1MB];
    }
}
