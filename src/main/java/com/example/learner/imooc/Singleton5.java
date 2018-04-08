package com.example.learner.imooc;

/**
 * Created by LiQian_Nice on 2018/4/8
 */
// 线程安全的懒汉式单例
public class Singleton5 {

    // 私有内部类，按需加载，用时加载，也就是延迟加载
    private static class Holder {
        private static Singleton5 singleton5 = new Singleton5();
    }

    private Singleton5() {

    }

    public static Singleton5 getSingleton5() {
        return Holder.singleton5;
    }
}
