package com.lks.proxy.factory;

import com.lks.proxy.invocation.MyInvocation;
import com.lks.proxy.service.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by likaisong on 2019/2/28.
 */

/**
 * 4、监听对象
 被监控的对象 需要被监控的行为 具体通知类实例对象 向JVM申请拦截
 */
public class MySqlSessionFactory {

    public static MySqlSession builder(Class classFile) throws IllegalAccessException, InstantiationException {
        /**
         * 针对接口编程
         */
        //需要被监控的行为，被监控的对象
        MySqlSession session = (MySqlSession) classFile.newInstance();
        //具体通知类实例对象
        InvocationHandler invocationHandler = new MyInvocation(session);
        //向JVM申请代理拦截
        MySqlSession $proxy = (MySqlSession) Proxy.newProxyInstance(classFile.getClassLoader(), classFile.getInterfaces(), invocationHandler);
        return $proxy;
    }
}
