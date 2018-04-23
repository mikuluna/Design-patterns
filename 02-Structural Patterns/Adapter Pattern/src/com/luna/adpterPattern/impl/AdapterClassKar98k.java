package com.luna.adpterPattern.impl;

import com.luna.adpterPattern.Appliance;

/**
 * 新型98k又可以射击，又可以敲打人
 */
public class AdapterClassKar98k extends Kar98k implements Appliance {
    @Override
    public void hiting() {
        System.out.println("新型98k在敲打人");
    }
}
