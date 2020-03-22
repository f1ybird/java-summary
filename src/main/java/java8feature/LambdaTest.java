package java8feature;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description: lambda表达式，在Java中又称为闭包或匿名函数
 * @Author: zhangkai
 * @Date: 2020/3/22 23:46
 */
public class LambdaTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");

        //list.forEach(n -> System.out.println(n));
        //1.方法引用    仅当该方法不修改lambda表达式提供的参数时可以替换为方法引用
        //list.forEach(System.out::println);

        //2.惰性求值方法
        //list.stream().filter(f -> f.equals("3"));

        //3.及早求值方法
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("p0", 0));
//        personList.add(new Person("p1", 1));
        //返回过滤后的list
        //List<Person> personList1 = personList.stream().filter(f -> f.getName().equals("p1")).collect(Collectors.toList());
        //personList1.forEach(t-> System.out.println(t.getName()));

        //顺序流
//        List<Person> streamList = personList.stream().collect(Collectors.toList());
//        streamList.forEach(t-> System.out.println(t.getName()));

        //并行流
//        List<Person> personList1 = personList.parallelStream().collect(Collectors.toList());
//        personList1.forEach(t -> System.out.println(t.getName()));

        //顺序流和并行流的性能测试
//        long t0 = System.nanoTime();
//        int[] serialArray = IntStream.range(0, 100_000).filter(f -> f % 2 == 0).toArray();
//        long t1 = System.nanoTime();
//        int[] parallelArray = IntStream.range(0, 100_000).parallel().filter(f -> f % 2 == 0).toArray();
//        long t2 = System.nanoTime();
//
//        //serial: 0.21s, parallel 0.02s
//        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

        //构造引用
        //类名::静态方法
//        Stream<Double> generate = Stream.generate(Math::random);

        //Filter & Predicate用法
//        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

//        System.out.println("Languages which starts with J :");
//        filter(languages, (str) -> str.startsWith("J"));
//
//        System.out.println("Languages which ends with a ");
//        filter(languages, (str) -> str.endsWith("a"));

//        System.out.println("Print all languages :");
//        filter(languages, (str) -> true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str) -> false);

//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str) -> str.length() > 4);

        //Map&Reduce 用法
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double bill = costBeforeTax.stream().map((cost) -> cost + 2 * cost).reduce((sum, cost) -> sum + cost).get();
//        System.out.println("Total : " + bill);


        // 将字符串换成大写并用逗号链接起来
//        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
//        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
//        System.out.println(G7Countries);

        //flatMap，将多个Stream连接成一个Stream
//        List<Integer> result = Stream.of(Arrays.asList(1, 3), Arrays.asList(5, 6)).flatMap(a -> a.stream()).collect(Collectors.toList());
//        result.forEach(System.out::println);

        //distinct 去重
//        List<LikeDO> likeDOs=new ArrayList<LikeDO>();
//        List<Long> likeTidList = likeDOs.stream().map(LikeDO::getTid).distinct().collect(Collectors.toList());

        //coun计数
//        int countOfAdult=persons.stream()
//                .filter(p -> p.getAge() > 18)
//                .map(person -> new Adult(person))
//                .count();


        //summaryStatistics统计信息，获取数字的个数、最小值、最大值、总和以及平均值
//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
//        System.out.println("Highest prime number in List : " + stats.getMax());
//        System.out.println("Lowest prime number in List : " + stats.getMin());
//        System.out.println("Sum of all prime numbers : " + stats.getSum());
//        System.out.println("Average of all prime numbers : " + stats.getAverage());

        //分组groupingBy
        List<String> phones = new ArrayList<>();
        phones.add("a");
        phones.add("b");
        phones.add("a");
        phones.add("a");
        phones.add("c");
        phones.add("b");
        Map<String, List<String>> phoneClassify = phones.stream().collect(Collectors.groupingBy(item -> item));
        System.out.println(phoneClassify);
    }


    public static void filter(List<String> names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> System.out.println(name + " "));
    }
}
