package volatileTest;

/**
 * @Description: 改进传统DCL单例模式
 * @Author: zhangkai
 * @Date: 2020/3/8 18:15
 */
public class Instance {

    private String str = "";
    private int a = 0;

    private volatile static Instance instance;

    /**
     * 构造方法私有化
     */
    private Instance() {
        str = "hello";
        a = 20;
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
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}
