package com.lks.test;

import com.lks.domain.User;
import com.lks.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by likaisong on 2019/2/24.
 */
public class TestMain {

    private static SqlSession getSqlSession(String resource){
        if (resource == null || "".equals(resource)){
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }
    @Test
    public static void testSelectByXml(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            String statement = "userMapper.getUser";
            User user = session.selectOne(statement, 2);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    @Test
    public static void testInsertByXml(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            String statement = "userMapper.insertUser";
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            session.insert(statement, user);
            session.commit();
            System.out.println("插入数据后返回的自增ID：" + user.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public static void testUpdateByXml(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            String statement = "userMapper.updateUser";
            User user = new User();
            user.setId(1);
            user.setName("小李飞刀");
            session.update(statement, user);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public static void testDeleteByXml(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            //先增加一条数据
            String insertStatement = "userMapper.insertUser";
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            session.insert(insertStatement, user);
            System.out.println("插入数据后返回的自增ID：" + user.getId());
            //再删掉刚刚加的数据
            String deleteStatement = "userMapper.deleteUser";
            session.delete(deleteStatement, user.getId());
            session.commit();
        } finally {
            session.close();
        }
    }


    @Test
    public static void testSelectByAnnotation(){
        String resource = "mybatis-annotation-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUser(1);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    @Test
    public static void testUpdateByAnnotation(){
        String resource = "mybatis-annotation-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2);
            user.setName("钢铁侠");
            mapper.updateUser(user);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public static void testInsertByAnnotation(){
        String resource = "mybatis-annotation-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            mapper.insertUser(user);
            session.commit();
            System.out.println("插入数据后返回的自增ID：" + user.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public static void testDeleteByAnnotation(){
        String resource = "mybatis-annotation-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            //先添加一条数据
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            mapper.insertUser(user);
            System.out.println("插入数据后返回的自增ID：" + user.getId());
            //再删除刚加的数据
            mapper.deleteUser(user.getId());
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public static void testDateToString(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            String statement = "userMapper.dateToString";
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            user.setDate(new Date());
            session.insert(statement, user);
            session.commit();
            System.out.println("插入数据后返回的自增ID：" + user.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public static void testStringToDate(){
        String resource = "mybatis-config.xml";
        SqlSession session = getSqlSession(resource);
        try {
            //先插入一条数据
            String insertStatement = "userMapper.dateToString";
            User user = new User();
            user.setName("阿飞");
            user.setAge(20);
            user.setCounty("中国");
            user.setDate(new Date());
            session.insert(insertStatement, user);
            session.commit();
            System.out.println("插入数据后返回的自增ID：" + user.getId());
            //查询刚插入的数据
            String selectStatement = "userMapper.stringToDate";
            User resUser = session.selectOne(selectStatement, user.getId());
            System.out.println(resUser);
        } finally {
            session.close();
        }
    }

}
