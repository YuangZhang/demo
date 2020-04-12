package com.demo.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/12 4:11 下午
 * @Description
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface in){
        in.doSomething();
        in.somethingElse("apple");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        //重新生成一个代理类
        //代理类 extends proxy implements Interface
        //代理类的构造函数参数为InvocationHandler
        //所以调用方法时代理类会调用InvocationHandler中的invoke()方法
        //由于被代理类持有代理类的引用，所以会在基础的方法前后进行其他操作
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(new RealObject())
        );
        System.out.println(proxy.getClass());
        consumer(proxy);
    }

}
