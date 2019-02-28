package com.lks.proxy.factory;

import com.lks.proxy.invocation.Invocation;
import com.lks.proxy.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by likaisong on 2019/2/28.
 */
public class ProxyFactory {
    public static BaseService builder(Class classFile) throws IllegalAccessException, InstantiationException {
        BaseService service = (BaseService) classFile.newInstance();
        InvocationHandler handler = new Invocation(service);
        BaseService proxy = (BaseService) Proxy.newProxyInstance(classFile.getClassLoader(), classFile.getInterfaces(), handler);
        return proxy;
    }
}
