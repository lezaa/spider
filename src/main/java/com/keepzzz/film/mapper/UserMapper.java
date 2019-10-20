package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.User;
import com.keepzzz.film.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserMapper {


    @InsertProvider(type = UserProvider.class,method = "addUser")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int addUser(User user);


    @Select("select * from user where id = #{userId} ")
    User getUser(long userId);


    @Select("select * from user where username = #{username}")
    User getUserByUsername( String username);

    @UpdateProvider(type = UserProvider.class,method = "updateUser")
    int updateUser(User user);
}
