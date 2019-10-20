package com.keepzzz.film.service.impl;


import com.keepzzz.film.base.Cproperty;
import com.keepzzz.film.domain.User;
import com.keepzzz.film.dto.UserInfo;
import com.keepzzz.film.mapper.UserMapper;
import com.keepzzz.film.service.RedisService;
import com.keepzzz.film.service.UserService;
import com.keepzzz.film.utils.IdCardUtil;
import com.keepzzz.film.utils.JwtUtil;
import com.keepzzz.film.utils.MD5Util;
import com.keepzzz.film.vo.RegisterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    private static final long EXPIRE_TIME = 120;

    private static final String PREFIX_USER = "user:";

    @Autowired
    private UserMapper userMapper;



    @Override
    public boolean login(String username,String password) {
        log.info("api:login`user_name={}`",username);
        //todo 密码加密
        User user = userMapper.getUserByUsername(username);
        if(user != null){
                String pwd = MD5Util.inputPassToDBPass(password, Cproperty.salt);
                if(pwd.equals(user.getPassword())){
                    String token = JwtUtil.geneJsonWebToken(user);
                    System.out.println("======"+token+"=====");
                    return true;
                }else {
                    log.error("用户id:{},密码错误!",user.getUsername());
                    return false;
                }
        }
        return false;
    }

    @Override
    public boolean register(RegisterVO registerVO) {
        User user = new User();
        BeanUtils.copyProperties(registerVO,user);
        String pwd = MD5Util.inputPassToDBPass(user.getPassword(),Cproperty.salt);
        user.setPassword(pwd);
        //设置默认头像
        user.setUserPhoto("http://1.jpg");
        //设置默认权限
        user.setRole("user");
       // boolean flag = IdCardUtil.validateIdCard(user.getIdCard());
        //用户名唯一
        String username = user.getUsername();
        if( userMapper.getUserByUsername(username) == null){
            log.info("api:regist`user_id={}",user.getUsername());
            return userMapper.addUser(user) > 0;
        }
        return false;
    }

    @Override
    public UserInfo getUser(long userId) {
        User user = userMapper.getUser(userId);
        if(user != null){
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(user,userInfo);
            return userInfo;
        }
        log.error("查询不到指定的用户信息");
        return null;
    }

    @Override
    public boolean editUserInfo(UserInfo userInfo) {
        User user = userMapper.getUser(userInfo.getId());
        if(null != user){
            BeanUtils.copyProperties(userInfo,user);
            return userMapper.updateUser(user) > 0;
        }
        return false;
    }
}
