package programtest.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description: 磁盘的容量单位有M、G、T，其关系为 1T = 1000G、1G = 1000M，
 * 如样例所示先输入磁盘的个数，再依次输入磁盘的容量大小，然后按照从小到大的顺序对磁盘容量进行排序并输出。
 * <p>
 * 输入：
 * 3
 * 20M
 * 1T
 * 3G
 * <p>
 * 输出：
 * 20M
 * 3G
 * 1T
 * @Author: zhangkai
 * @Date: 2020/5/30 16:38
 */
public class StrToInt {

    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        TreeSet<Integer> set = new TreeSet<>();
        int num = 4;
        for (int i = 0; i < num; i++) {
            str = input.nextLine();
            if (str.endsWith("G") || str.endsWith("T")) {
                set.add(conver(str));
            } else if (str.endsWith("M")) {
                map.put(Integer.parseInt(str.substring(0, str.length() - 1)), str);
                set.add(Integer.parseInt(str.substring(0, str.length() - 1)));
            } else {
                continue;
            }
        }

        for (Integer integer : set) {
            System.out.println(map.get(integer));
        }
    }

    public static int conver(String str) {
        int val = 0;
        if (str.endsWith("G")) {
            val = Integer.parseInt(str.substring(0, str.length() - 1)) * 1000;
        } else if (str.endsWith("T")) {
            val = Integer.parseInt(str.substring(0, str.length() - 1)) * 1000 * 1000;
        }
        map.put(val, str);
        return val;
    }
}
