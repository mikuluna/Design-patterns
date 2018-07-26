package com.luna.responsibilityPattern;

import com.luna.responsibilityPattern.client.ChainOfResponsibilityClient;
import com.luna.responsibilityPattern.mode.Request;

public class Test {
    public static void main(String[] args) {
        Request request = new Request.Builder().setName("张三").setDays(3)
                .setReason("事假").build();
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        Result result = client.execute(request);
        System.out.println("结果："+result.toString());
    }
}
