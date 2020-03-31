package multhread.volatileTest;

/**
 * @Description: DCL单例模式
 * @Author: zhangkai
 * @Date: 2020/3/8 18:15
 */
public class Instance {

    /**
     * 使用volatile修饰禁止指令重排
     */
    private volatile static Instance instance;

    /**
     * 构造方法私有化
     */
    private Instance() {
    }

    /**
     * DCL方式获取单例
     */
    public static Instance getInstance() {
        if (instance == null) {
            synchronized (Instance.class) {
                if (instance == null) {
                    //此处可能存在instance初始化不完整导致其他线程获取到不完整的实例
                    //instance增加volatile修饰：对volatile字段的写操作happen-before后续的对同一个字段的读操作
                    instance = new Instance();//可能半初始化
                }
            }
        }
        return instance;
    }

}
