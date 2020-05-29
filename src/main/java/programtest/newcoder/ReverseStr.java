package programtest.newcoder;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class ReverseStr {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(reverse(input.nextLine()));
    }

    public static String reverse(String sentence) {
        String[] split = sentence.split(" ");
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        Collections.reverse(list);
        AtomicReference<String> result = new AtomicReference<>("");
        list.forEach(s -> result.updateAndGet(v -> v + s + " "));
        return result.toString();
    }
}
