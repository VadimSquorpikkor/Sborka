package com.squorpikkor.android.app.sborka;

// Created by VadimSquorpikkor on 28.03.2017.

import java.util.ArrayList;

public class Device {
    String deviceName;
    private ArrayList<Detail> deviceList;

    public Device(String deviceName) {
        deviceList = new ArrayList<>();
        this.deviceName = deviceName;
    }

    public void addDetail(String name, String number) {
        deviceList.add(new Detail(name, number));
    }
}
