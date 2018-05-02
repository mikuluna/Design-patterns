package com.luna.filter.model;

/**
 * 车类
 */
public class Car {
    //车名
    private String name;
    //车颜色
    private String color;
    //车轮胎数量
    private String tyreNum;

    public Car(String name, String color, String tyreNum) {
        this.name = name;
        this.color = color;
        this.tyreNum = tyreNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(String tyreNum) {
        this.tyreNum = tyreNum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", tyreNum='" + tyreNum + '\'' +
                '}';
    }
}
