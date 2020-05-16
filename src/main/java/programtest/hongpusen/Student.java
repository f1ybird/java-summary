package programtest.hongpusen;

import java.lang.reflect.Method;

public class Student {

    private int age = 12;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void hi(int age, String name) {
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁");
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("programtest.hongpusen.Student");

            //调用非静态方法
            Method method = clazz.getMethod("getAge");
            System.out.println(method.invoke(clazz.newInstance()));

            //调用静态方法
            Method hi = clazz.getMethod("hi", int.class, String.class);
            hi.invoke(clazz,12,"小米");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}