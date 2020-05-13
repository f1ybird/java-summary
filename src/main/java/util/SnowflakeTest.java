package util;

import cn.hutool.core.lang.Snowflake;

/**
 * @Description: hutool雪花算法获取分布式系统全局唯一Id方案
 * @Author: zhangkai
 * @Date: 2020/5/13 23:30
 */
public class SnowflakeTest {

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(0,0);
        long id = snowflake.nextId();
        System.out.println(id);
    }
}
