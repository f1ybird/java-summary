package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 函数编程测试
 * @Author: zhangkai
 * @Date: 2020/5/14 0:10
 */
public class FuncProgramTest {

    public static void main(String[] args) {

//        List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7});
//        int factor = 2;

        //lambda内部只能引用final类型的局部变量，否则会报错
//        primes.forEach(element -> { factor++; });

        //只是访问它，而不是修改则不会报错
//        primes.forEach(element -> System.out.println(factor * element));

//        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
//        String collect = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
//        System.out.println(collect);

//        List<Integer> list = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(a -> a.stream()).collect(Collectors.toList());
//        System.out.println(list.toString());


        Optional<String> name = Optional.of("java");
        if (name.isPresent()) {
            System.out.println(name.get());
        }
        Optional<Object> empty = Optional.ofNullable(null);

        //如果值不为null，orElse方法返回Optional实例的值。
        //如果为null，返回传入的消息。
        //输出: There is no value present!
        System.out.println(empty.orElse("There is no value present!"));
        //输出: Sanaulla
        System.out.println(name.orElse("There is some value!"));
    }

}
