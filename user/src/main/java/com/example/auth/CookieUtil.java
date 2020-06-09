package com.example.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: mallproj
 * @BelongsPackage: com.wn.auth.utils
 * @Author: 闫靖方
 * @CreateTime: 2020-05-14 11:53
 * @Description:
 */
public class CookieUtil {
    public static void responseCookie(String key, String value, Integer time, HttpServletResponse response){
        //创建cookie对象，并向cookie中写入token
        Cookie cookie = new Cookie(key,value);
        //设置cookie的域
        cookie.setDomain("bajin.com");
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
