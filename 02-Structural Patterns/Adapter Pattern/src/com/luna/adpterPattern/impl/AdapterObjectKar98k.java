package com.luna.adpterPattern.impl;

import com.luna.adpterPattern.Appliance;
import com.luna.adpterPattern.Gun;

public class AdapterObjectKar98k implements Appliance {
    private Gun gun;
    public AdapterObjectKar98k(Gun gun){
        this.gun = gun;
    }
    @Override
    public void hiting() {
        System.out.println("新型98k在敲打人");
    }

    @Override
    public void shooting() {
        gun.shooting();
    }
}
