package jvm.understandjvm.ch7_classloader;

/**
 * @Description: ·<clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块（static{}块） 中的
 * 语句合并产生的， 编译器收集的顺序是由语句在源文件中出现的顺序决定的， 静态语句块中只能访问
 * 到定义在静态语句块之前的变量， 定义在它之后的变量， 在前面的静态语句块可以赋值， 但是不能访问，
 * @Author: zhangkai
 * @Date: 2020/4/7 23:15
*/
public class InitTest {

    static {
        i = 1;
        //Illegal forward reference 会报错，非法向前引用
        //System.out.println(i);
    }

    static int i = 0;
}
