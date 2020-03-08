package unsafeTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description: 测试unsafe.compareAndSwapInt
 * @Author: zhangkai
 * @Date: 2020/3/8 22:15
 */
public class T1 {

    int i = 0;
    private static T1 t1 = new T1();

    public static void main(String[] args) {
        try {
            //通过反射获取单例对象theUnsafe。
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);

            //通过反射获取i的内存偏移量
            Field ii = T1.class.getDeclaredField("i");
            long iOffset = unsafe.objectFieldOffset(ii);
            System.out.println("iOffset:" + iOffset);

            //CAS底层使用的是原子指令lock cmpxchg，所以不会造成数据不一致问题
            if (unsafe.compareAndSwapInt(t1, iOffset, 0, 1)) {
                //如果内存位置的值（val[ioffset]）==预期原值(0)，则更新内存位置的值为新值(1)，否则不做任何操作
                System.out.println("i:" + t1.i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
