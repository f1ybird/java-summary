package programtest.newcoder;

import java.util.*;

public class IndexSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        while (input.hasNext()) {
            for (int i = 0; i < count; i++) {
                int key = input.nextInt();
                int value = input.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
