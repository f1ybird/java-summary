package multhread.javase;

import java.util.Set;
import java.util.TreeMap;

/**
 * @Description: 测试Comparable比较器和TreeMap
 * @Author: zhangkai
 * @Date: 2020/3/16 23:27
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * TODO重写compareTo⽅法实现按年龄来排序
     */
    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return age;
    }

    /**
     * 测试treeMap的比较器
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>();
        treeMap.put(new Person("张三", 30), "zhangsan");
        treeMap.put(new Person("李四", 20), "lisi");
        treeMap.put(new Person("王五", 10), "wangwu");
        treeMap.put(new Person("小红", 5), "xiaohong");

        Set<Person> keys = treeMap.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());
        }
    }
}