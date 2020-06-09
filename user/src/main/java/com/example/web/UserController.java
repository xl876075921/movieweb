package com.example.web;

import com.example.auth.CookieUtil;
import com.example.auth.JWTUtil;
import com.example.common.Const;
import com.example.pojo.UserInfo;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: movieweb
 * @BelongsPackage: com.example.web
 * @Author: 闫靖方
 * @CreateTime: 2020-06-09 11:44
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    public String login(UserInfo user, HttpServletResponse response){
        UserInfo login = userService.login(user);
        if(login == null){
             return null;
        }else{
            String s = JWTUtil.generateToken(login, 30, Const.RsaPath.PRIVATE_RSA);
            CookieUtil.responseCookie("utoken",s,1800,response);
            return null;
        }
    }
}