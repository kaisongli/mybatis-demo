package com.lks.proxy.service;

/**
 * Created by likaisong on 2019/2/28.
 */

/**
 * 1、监控接口
 定义所有需要被监听的行为
 */
public interface MySqlSession {
    void save(String sql);
}
