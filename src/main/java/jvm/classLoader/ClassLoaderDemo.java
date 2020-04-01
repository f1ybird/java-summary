package jvm.classLoader;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 类加载器测试
 * @Author: zhangkai
 * @Date: 2020/4/1 21:45
 */
@Slf4j
public class ClassLoaderDemo {

    public static void main(String[] args) {
        log.info("ClassLoaderDemo.class.getClassLoader():,{}", ClassLoaderDemo.class.getClassLoader());
        log.info("ClassLoaderDemo.class.getClassLoader().getParent():,{}", ClassLoaderDemo.class.getClassLoader().getParent());
        log.info("ClassLoaderDemo.class.getClassLoader().getParent().getParent():,{}", ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
