package com.luna.prototype;

import java.io.*;
import java.util.ArrayList;

public class TestDeepCopy {
    public static Object deepCopy(Object from) {
        Object obj = null;
        try {
            // 将对象写成 Byte Array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(from);
            out.flush();
            out.close();

            // 从流中读出 byte array，调用readObject函数反序列化出对象
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        //1.一个HamburgerMeal对象我们称为Luna的汉堡套餐
        HamburgerMeal hamburgerMealForLuna = new HamburgerMeal("cola","beef burger","chips");
        ArrayList<String> seasoningPackets = new ArrayList<String>();
        seasoningPackets.add("辣椒包");
        seasoningPackets.add("宫保酱");
        seasoningPackets.add("川味酱");
        hamburgerMealForLuna.setSeasoningPackets(seasoningPackets);
        Customer customerLuna = new Customer("luna","20");
        hamburgerMealForLuna.setCustomer(customerLuna);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("===========================================");
        //2.用写好的序列化的方法进行复制
        HamburgerMeal hamburgerMealForMiku = (HamburgerMeal) deepCopy(hamburgerMealForLuna);
        hamburgerMealForMiku.getCustomer().setName("miku");
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
    }
}
