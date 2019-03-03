package com.lks.test;

import com.lks.bean.User;
import com.lks.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by likaisong on 2019/2/24.
 */
public class TestMain {
    private SqlSession session;

    @BeforeTest
    private void getSqlSession() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testSelectByXml() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUser(2);
        System.out.println(user);
    }

    @Test
    public void testInsertByXml() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("阿飞");
        user.setAge(20);
        user.setCounty("中国");
        mapper.insertUser(user);
        session.commit();
        System.out.println("插入数据后返回的自增ID：" + user.getId());

    }

    @Test
    public void testUpdateByXml() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("小李飞刀");
        mapper.updateUser(user);
        session.commit();

    }

    @Test
    public void testDeleteByXml() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        //先增加一条数据
        User user = new User();
        user.setName("阿飞");
        user.setAge(20);
        user.setCounty("中国");
        mapper.insertUser(user);
        System.out.println("插入数据后返回的自增ID：" + user.getId());
        //再删掉刚刚加的数据
        mapper.deleteUser(user.getId());
        session.commit();

    }

    @Test
    public void testDateToString() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("阿飞");
        user.setAge(20);
        user.setCounty("中国");
        user.setDate(new Date());
        mapper.dateToString(user);
        session.commit();
        System.out.println("插入数据后返回的自增ID：" + user.getId());

    }

    @Test
    public void testStringToDate() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        //先插入一条数据
        User user = new User();
        user.setName("阿飞");
        user.setAge(20);
        user.setCounty("中国");
        user.setDate(new Date());
        mapper.dateToString(user);
        session.commit();
        System.out.println("插入数据后返回的自增ID：" + user.getId());
        //查询刚插入的数据
        User resUser = mapper.stringToDate(user.getId());
        System.out.println(resUser);

    }

    @Test
    public void testQueryIntercepor() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryInterceptor(1);
        System.out.println(user);
    }

    @Test
    public void testChooseTable() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.chooseTable("users", 1);
        System.out.println(user);

    }

    @Test
    public void testResultMapNewKey() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.resultMapTypeChange(1);
        System.out.println(user);
    }

    @Test
    public void testDynamicSqlWhereIf() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("小李飞刀");
        user.setCounty("中国");
        User resUser = mapper.dynamicSqlWhereIf(user);
        System.out.println(resUser);
    }

    @Test
    public void testDynamicSqlChoose() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("小李飞刀");
        user.setCounty("中国");
        User resUser = mapper.dynamicSqlChoose(user);
        System.out.println(resUser);
    }

    @Test
    public void testUpdateSet() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("李寻欢");
        user.setCounty("中国");
        mapper.updateSet(user);
        session.commit();
    }

    @Test
    public void testDynamicSqlTrim() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("阿飞");
        user.setCounty("中国");
        List<User> list = mapper.dynamicSqlTrim(user);
        System.out.println(list.toString());
    }

    @Test
    public void testDynamicSqlInsertList() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("楚留香");
        user.setAge(20);
        user.setCounty("中国");
        user.setDate(new Date());
        User user2 = new User();
        user2.setName("美国队长");
        user2.setAge(50);
        user2.setCounty("美国");
        user2.setDate(new Date());
        list.add(user);
        list.add(user2);
        mapper.dynamicSqlInsertList(list);
        session.commit();
    }

    @Test
    public void testDynamicSqlSelectList() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(21);
        List<User> users = mapper.dynamicSqlSelectList(list);
        System.out.println(users.toString());
    }

    @Test
    public void testDynamicSqlSelectArray() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        Integer[] array = {1, 6};
        List<User> users = mapper.dynamicSqlSelectArray(array);
        System.out.println(users.toString());
    }

    @Test
    public void testDynamicSqlSelectMap() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map map = new HashMap();
        map.put("name", "阿飞");
        List<User> users = mapper.dynamicSqlSelectMap(map);
        System.out.println(users.toString());
    }

    @Test
    public void testOneToMoreQuery() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List users = mapper.oneToMoreQuery(1);
        System.out.println(users.toString());
    }

    @Test
    public void testOneToMoreQuery2() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List users = mapper.oneToMoreQuery2(1);
        System.out.println(users.toString());
    }

    @Test
    public void testMoreToOneQuery() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List users = mapper.moreToOneQuery(1);
        System.out.println(users.toString());
    }

    @Test
    public void testMoreToMoreQuery() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List users = mapper.moreToMoreQuery(1);
        System.out.println(users.toString());
    }

    @Test
    public void testMoreToMoreQuery2() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List users = mapper.moreToMoreQuery2(1);
        System.out.println(users.toString());
    }


    @AfterTest
    public void closeSession() {
        session.close();
    }
}
