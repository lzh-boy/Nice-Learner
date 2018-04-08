package com.example.learner.imooc;

/**
 * Created by LiQian_Nice on 2018/4/8
 *
 * 懒汉模式
 * 区别：饿汉模式的特点加载类时比较慢，但运行时获取对象的速度比较快，线程安全
 *      懒汉模式的特点加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
 */
public class Singleton6 {

    //1.将构造方法私有化，不允许外部直接创建对象
    private Singleton6(){

    }
    //2.创建类的唯一实例,使用private static修饰
    private static Singleton6 instance;

    //3.提供一个用于获取实例的方法
    //使用 synchronized 修饰，临界资源的同步互斥访问
    public static synchronized Singleton6 getInstance(){
        if (instance==null){
            instance=new Singleton6();
        }
        return instance;
    }
}
