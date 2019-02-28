package com.lks.proxy.impl;

import com.lks.proxy.service.MySqlSession;

/**
 * Created by likaisong on 2019/2/28.
 */

/**
 * 2、接口实现
 谁来实现需要被监控的接口
 */
public class UserImpl implements MySqlSession{
    @Override
    public void save(String sql) {
        System.out.println("sql语句：" + sql);
        System.out.println("user更改保存.......");
    }
}
