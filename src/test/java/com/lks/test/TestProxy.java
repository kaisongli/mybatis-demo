package com.lks.test;

import com.lks.proxy.factory.MySqlSessionFactory;
import com.lks.proxy.factory.ProxyFactory;
import com.lks.proxy.impl.Person;
import com.lks.proxy.impl.UserImpl;
import com.lks.proxy.service.BaseService;
import com.lks.proxy.service.MySqlSession;
import org.testng.annotations.Test;

/**
 * Created by likaisong on 2019/2/28.
 */
public class TestProxy {
    @Test
    public void testProxy() throws InstantiationException, IllegalAccessException {
        BaseService mike = ProxyFactory.builder(Person.class);
        mike.eat();
    }

    @Test
    public void testMySqlSession() throws InstantiationException, IllegalAccessException {
        MySqlSession session = MySqlSessionFactory.builder(UserImpl.class);
        session.save("insert into tableName (column1, column2, column3) values (value1, value2, value3);");
    }
}
