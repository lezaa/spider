package com.keepzzz.film.service;

import com.keepzzz.film.dto.UserInfo;
import com.keepzzz.film.vo.RegisterVO;

public interface UserService {

    boolean login(String username,String password);


    boolean register(RegisterVO registerVO);


    //boolean updateInfo(User user);

    UserInfo getUser(long userId);

    boolean editUserInfo(UserInfo userInfo);
}
