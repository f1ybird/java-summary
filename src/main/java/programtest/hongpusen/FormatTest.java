package programtest.hongpusen;

/**
 * @Description: 鸿普森-按照要求输出*号
 * 如：n=4,输出：
 *     *
 *    *
 *   *
 * *
 * @Author: zhangkai
 * @Date: 2020/5/16 11:16
 */
public class FormatTest {

    public static void main(String[] args) {
        int n =4;
        for (int i = 0; i < n; i++) {
            for (int j=n-i; j>0; j--) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
