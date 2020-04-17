package multhread.juc;

import java.util.concurrent.DelayQueue;

/**
 * @Description: 网吧类，模拟上网充钱倒计时
 * @Author: zhangkai
 * @Date: 2020/4/17 16:33
 */
public class WangBa implements Runnable {

    private DelayQueue<WangMing> queue = new DelayQueue<WangMing>();

    public boolean yingye = true;

    /**
     * 上机
     */
    public void shangji(String name, String id, int money) {
        WangMing man = new WangMing(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("网名：" + man.getName() + " 身份证：" + man.getId() + "交钱：" + money + "块,开始上机...");
        this.queue.add(man);
    }

    // 下机
    public void xiaji(WangMing man) {
        System.out.println("网名：" + man.getName() + " 身份证：" + man.getId() + "时间到下机...");
    }

    @Override
    public void run() {
        while (yingye) {
            try {
                WangMing man = queue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println("网吧开始营业");
            WangBa siyu = new WangBa();
            Thread shangwang = new Thread(siyu);
            shangwang.start();

            siyu.shangji("路人甲", "123", 1);
            siyu.shangji("路人乙", "234", 10);
            siyu.shangji("路人丙", "345", 5);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}