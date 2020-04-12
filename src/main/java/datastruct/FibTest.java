package datastruct;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 题目描述：
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * @Author: zhangkai
 * @Date: 2020/4/12 14:09
 */
@Slf4j
public class FibTest {

    /**
     * 1.暴⼒递归
     *
     * @param N
     * @return
     */
    static int fib1(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 2.带备忘录
     *
     * @param N
     * @return
     */
    public static int fib2(int N) {
        List fabList = new ArrayList();
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            fabList.add(0);
            fabList.add(1);
            for (int i = 2; i <= N; i++) {
                fabList.add((int) fabList.get(i - 2) + (int) fabList.get(i - 1));
            }
            return (int) fabList.get(N);
        }
    }

    /**
     * 3.只存储前两个值，占用更少的空间
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int temp1 = 0;
            int temp2 = 1;
            int temp3 = 0;
            for (int i = 2; i <= n; i++) {
                temp3 = temp1 + temp2;
                temp1 = temp2;
                temp2 = temp3;
            }
            return temp3;
        }
    }

    public static void main(String[] args) {
//        int start1 = DateUtil.thisMillsecond();
//        System.out.println(fib1(40));//102334155
//        log.info("时间：{}", DateUtil.thisMillsecond() - start1);//时间：452 536 444

//        int start2 = DateUtil.thisMillsecond();
//        System.out.println(fib2(50));//102334155
//        log.info("时间：{}", DateUtil.thisMillsecond() - start2);//时间：9 6 7

        int start3 = DateUtil.thisMillsecond();
        System.out.println(fib3(50));//102334155
        log.info("时间：{}", DateUtil.thisMillsecond() - start3);//时间：9 6 7
    }

}
