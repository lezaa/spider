package com.keepzzz.film.utils;

import com.keepzzz.film.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt 工具类
 */
public class JwtUtil {

    public static final String SUBJECT="keepzzz";
    //过期时间为一周
    public static final Long EXPIRE=1000 * 60 * 60 * 24 * 7L;

    public static final String APPSECRET="keepzzz666";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        if(user == null || user.getId() == null || user.getUsername() == null
        || user.getPhone() == null){
            return null;
        }
        return Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("username",user.getUsername())
                .claim("phone",user.getPhone())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
    }

    public static Claims checkJWT(String token){
        try{
           return Jwts.parser().setSigningKey(APPSECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return null;
        }
    }

}
