package com.demo.dynamicProxy;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/12 4:13 下午
 * @Description
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("do something else:"+arg);
    }
}
