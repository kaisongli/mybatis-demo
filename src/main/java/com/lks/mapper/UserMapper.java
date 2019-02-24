package com.lks.mapper;

import com.lks.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by likaisong on 2019/2/24.
 */
public interface UserMapper {
    @Select("select * from users where id=#{id}")
    User getUser(int id);

    @Update("update users set name = #{name} where id = #{id}")
    void updateUser(User user);

    @Insert("insert into users (id,name,age,county) values (#{id},#{name},#{age},#{county})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insertUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(int id);
}
