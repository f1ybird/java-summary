package multhread.finalTest;

/**
 * @Description: 说说final类型的类如何拓展? 比如String是final类型，
 * 我们想写个MyString复用所有String中方法，
 * 同时增加一个新的toMyString()的方法，应该如何做?
 * <p>
 * 设计模式中最重要的两种关系，一种是继承/实现；另外一种是组合关系。所以当遇到不能用继承的(final修饰的类),应该考虑用组合, 如下代码大概写个组合实现的意思：
 * @Author: zhangkai
 * @Date: 2020/3/22 15:04
 */
public class MyString {

    //使用组合方式复用原String方法
    String innerString;

    /**
     * 复用原String方法
     *
     * @return
     */
    public int length() {
        return innerString.length();
    }

    /**
     * 实现自己的方法
     *
     * @return
     */
    public String toMyString() {
        return "";
    }

}
