package com.demo.rpc.client;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/9 7:16 下午
 * @Description
 */
public class HelloServiceImpl implements HelloService {

    String name;
    String age;
    public HelloServiceImpl() {
    }

    public HelloServiceImpl(String name) {
        this.name = name;
    }


    public HelloServiceImpl(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String hello(int i) throws Exception{

        return 10/i+"";
    }

    private String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "HelloServiceImpl{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
