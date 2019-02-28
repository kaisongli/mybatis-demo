package com.lks.proxy.impl;

import com.lks.proxy.service.BaseService;

/**
 * Created by likaisong on 2019/2/27.
 */
public class Person implements BaseService{
    @Override
    public void eat() {
        System.out.println("吃饭。。。。。");
    }

    @Override
    public void wc() {
        System.out.println("wc。。。。。");
    }
}
