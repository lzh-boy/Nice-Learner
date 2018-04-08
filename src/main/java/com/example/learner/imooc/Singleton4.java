package com.example.learner.imooc;

/**
 * Created by LiQian_Nice on 2018/4/8
 */
// 线程安全的懒汉式单例
public class Singleton4 {

    // ThreadLocal 线程局部变量
    private static ThreadLocal<Singleton4> threadLocal = new ThreadLocal<Singleton4>();
    private static Singleton4 singleton4 = null;    // 不需要是

    private Singleton4() {
    }

    public static Singleton4 getSingleton4() {
        if (threadLocal.get() == null) {        // 第一次检查：该线程是否第一次访问
            createSingleton4();
        }
        return singleton4;
    }

    public static void createSingleton4() {
        synchronized (Singleton4.class) {
            if (singleton4 == null) {          // 第二次检查：该单例是否被创建
                singleton4 = new Singleton4();   // 只执行一次
            }
        }
        threadLocal.set(singleton4);      // 将单例放入当前线程的局部变量中
    }
}