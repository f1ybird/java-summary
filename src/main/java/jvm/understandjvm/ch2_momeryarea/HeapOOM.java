package jvm.understandjvm.ch2_momeryarea;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java堆溢出测试
 * VM Args：-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./oomdumpfile
 * @Author: zhangkai
 * @Date: 2020/4/5 15:31
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
        while (true) {
            oomObjects.add(new OOMObject());
        }
    }
}
