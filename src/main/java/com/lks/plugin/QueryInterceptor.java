package com.lks.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by likaisong on 2019/2/25.
 */
@Intercepts(
        @Signature(method = "query" ,
        type = Executor.class,
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
)
public class QueryInterceptor implements Interceptor {
    /**
     * 拦截时执行的操作
     *
     * @param invocation { 代理对象，被监控方法对象，当前被监控方法运行时需要的实参 }
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("query被拦截方法执行前的操作。。。");
        Object proceed = invocation.proceed();
        System.out.println("query被拦截方法执行后的操作。。。");
        return proceed;
    }

    /**
     * 拦截器用于封装目标对象的
     * 通过该方法我们可以返回目标对象本身，也可以返回一个它的代理
     *
     * @param o
     * @return
     */
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    /**
     * 用于在 Mybatis 配置文件中指定一些属性的。
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
