package com.lks.dao;

import com.lks.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by likaisong on 2019/2/24.
 */
public interface UserMapper {
//    @Select("select * from users where id=#{id}")
    User getUser(int id);

//    @Update("update users set name = #{name} where id = #{id}")
    void updateUser(User user);

//    @Insert("insert into users (id,name,age,county) values (#{id},#{name},#{age},#{county})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insertUser(User user);

//    @Delete("delete from users where id = #{id}")
    void deleteUser(int id);

    @Select("select * from ${tableName} where id=#{id}")
    User chooseTable(@Param("tableName") String tableName, @Param("id") int id);

    void dateToString(User user);

    User stringToDate(int id);

    User queryInterceptor(int id);

    User resultMapTypeChange(int id);

    User dynamicSqlWhereIf(User user);

    User dynamicSqlChoose(User user);

    void updateSet(User user);

    List dynamicSqlTrim(User user);

    void dynamicSqlInsertList(List list);

    List dynamicSqlSelectList(List list);

    List dynamicSqlSelectArray(Integer[] ids);

    List dynamicSqlSelectMap(@Param("map") Map map);

    List oneToMoreQuery(int id);

    List oneToMoreQuery2(int id);

    List moreToOneQuery(int id);

    List moreToMoreQuery(int id);

    List moreToMoreQuery2(int id);

}
