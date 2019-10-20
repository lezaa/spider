package com.keepzzz.film.utils;

import com.keepzzz.film.base.Cproperty;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static String salt = Cproperty.salt;

    public static String md5(String src){
       return DigestUtils.md5Hex(src);
    }

    public static String inputPassFormPass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass,String salt){
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }


    public static String inputPassToDBPass(String input,String salt){
        String formPass = inputPassFormPass(input);
        String dbPass = formPassToDBPass(formPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("admin1234",salt));
    }

}
