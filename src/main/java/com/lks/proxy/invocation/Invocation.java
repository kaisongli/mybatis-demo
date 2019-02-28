package com.lks.proxy.invocation;

import com.lks.proxy.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by likaisong on 2019/2/27.
 */
public class Invocation implements InvocationHandler{
    private BaseService service;
    public Invocation(BaseService service){
        this.service = service;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object;
        String methodName = method.getName();
        if ("eat".equals(methodName)){
            wash();
            object = method.invoke(service, args);
        } else {
            object = method.invoke(service, args);
            wash();
        }
        return object;
    }

    private void wash(){
        System.out.println("洗手。。。。");
    }

}
