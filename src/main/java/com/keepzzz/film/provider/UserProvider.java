package com.keepzzz.film.provider;

import com.keepzzz.film.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String addUser(final User user){
        return new SQL(){{
            INSERT_INTO("user");
            if(user.getIdCard() != null){
                VALUES("id_card","#{idCard}");
            }
            if(user.getUsername() != null){
                VALUES("username","#{username}");
            }
            if(user.getPassword() != null){
                VALUES("password","#{password}");
            }
            if(user.getPhone() != null){
                VALUES("phone","#{phone}");
            }
            if(user.getUserPhoto() != null){
                VALUES("user_photo","#{userPhoto}");
            }
            if(user.getRealName() != null){
                VALUES("real_name","#{realName}");
            }
            if(user.getSex() != null){
                VALUES("sex","#{sex}");
            }
            if(user.getRole() != null){
                VALUES("role","#{role}");
            }
        }}.toString();
    }

    public String updateUser(final User user){
        return new SQL(){{
            UPDATE("user");
            if(user.getId() != null){
                SET("id = #{id}");
            }
            if(user.getIdCard() != null){
                SET("id_card = #{idCard}");
            }
            if(user.getUsername() != null){
                SET("username = #{username}");
            }
            if(user.getPassword() != null){
                SET("password = #{password}");
            }
            if(user.getPhone() != null){
                SET("phone = #{phone}");
            }
            if(user.getUserPhoto() != null){
                SET("user_photo = #{userPhoto}");
            }
            if(user.getRealName() != null){
                SET("real_name = #{realName}");
            }
            if(user.getSex() != null){
                SET("sex = #{sex}");
            }
            if(user.getRole() != null){
                SET("role = #{role}");
            }
        }}.toString();
    }
}
