package com.example.learner.imooc;

/**
 * Created by LiQian_Nice on 2018/4/8
 */
// 懒汉式单例
//单例实例被延迟加载，即只有在真正使用的时候才会实例化一个对象并交给自己的引用。
public class Singleton2 {

    // 指向自己实例的私有静态引用
    private static Singleton2 singleton2;

    // 私有的构造方法
    private Singleton2(){}

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static Singleton2 getSingleton2(){
        // 被动创建，在真正需要使用时才去创建
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
