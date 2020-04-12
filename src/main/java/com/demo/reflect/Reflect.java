package com.demo.reflect;

import com.demo.rpc.client.HelloService;
import com.demo.rpc.client.HelloServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/10 1:34 下午
 * @Description  反射就是从一个已有的对象获取到其类、方法的过程，通过反射可以动态的创建对象
 */
public class Reflect {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        //通过对象获取类
        Class<?> clazz = helloService.getClass();
        //获取构造器，创建新对象
        Object obj = clazz.getConstructor(String.class).newInstance("zya");
        Object obj2 = clazz.getConstructor(String.class, String.class).newInstance("zya", "16");

        //获取方法，甚至可以获取private方法

        //获取所有共有方法
        Method m = clazz.getMethod("hello", int.class);
        m.invoke(helloService, 0);
    }
}
