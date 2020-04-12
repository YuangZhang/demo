package com.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/12 4:08 下午
 * @Description
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * 最后被代理执行的方法
     *
     * @param proxy 转化后的代理实例
     * @param method 代理实例回调用的方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:  "+proxy.getClass()+"  method:  "+method.getName());
        return method.invoke(proxied, args);
    }
}
