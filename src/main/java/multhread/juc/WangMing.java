package multhread.juc;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 网民类实现延迟队列，模拟上网收费倒计时
 * @Author: zhangkai
 * @Date: 2020/4/17 16:31
 */
public class WangMing implements Delayed {

    /**
     * 网民姓名
     */
    private String name;

    /**
     * 身份证
     */
    private String id;

    /**
     * 截止时间
     */
    private Long endTime;

    /**
     * 定义时间工具类
     */
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public WangMing(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed delayed) {
        WangMing w = (WangMing) delayed;
        return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1 : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEndTime() {
        return endTime;
    }

}
