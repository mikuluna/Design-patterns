package com.luna.prototype;

import java.io.Serializable;

/**
 * 消费者类（作用是研究深拷贝和浅拷贝）
 */
public class Customer implements Cloneable,Serializable{
    private String name;//名字
    private String age;//年龄


    public Customer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Customer{name:"+name+",age:"+age+"}";
    }

    //将所有的getter和setter方法写好
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
