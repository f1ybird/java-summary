package multhread.singleton;

import multhread.annotation.ThreadSafe;

/**
 * @Description: 通过枚举实现安全的单例模式
 * @Author: zhangkai
 * @Date: 2020/3/24 0:05
 */
@ThreadSafe
public class SingletonEnumDemo {

    private SingletonEnumDemo() {
    }

    public static SingletonEnumDemo getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonEnumDemo singleton;

        Singleton() {
            singleton = new SingletonEnumDemo();
        }

        public SingletonEnumDemo getInstance() {
            return singleton;
        }
    }
}
