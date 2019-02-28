package com.lks.proxy.invocation;

import com.lks.proxy.service.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by likaisong on 2019/2/28.
 */

/**
 * 3、通知类
 次要业务具体实现 绑定主要和次要业务
 */
public class MyInvocation implements InvocationHandler{

    private MySqlSession session;

    public MyInvocation(MySqlSession sqlSession){
        this.session = sqlSession;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res;
        //次要业务具体实现 绑定主要和次要业务
        init();
        res = method.invoke(session, args);
        end();
        return res;
    }

    private void init(){
        System.out.println("连接数据库.........");
    }

    private void end(){
        System.out.println("关闭数据库........");
    }
}
