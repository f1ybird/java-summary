package programtest.hongpusen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter8Test {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> collect = list.stream().filter(i -> i.equals("a")).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
