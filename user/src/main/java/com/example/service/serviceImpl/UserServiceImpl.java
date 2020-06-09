package com.example.service.serviceImpl;

import com.example.mapper.UserInfoMapper;
import com.example.pojo.UserInfo;
import com.example.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: movieweb
 * @BelongsPackage: com.example.service.serviceImpl
 * @Author: 闫靖方
 * @CreateTime: 2020-06-09 11:14
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserInfoMapper userMapper;
    @Override
    public UserInfo login(UserInfo user) {
        /*Md5Hash md5Hash = new Md5Hash(user.getPassword(), "com.woniu", 5);
        String newPassWord = md5Hash.toString();
        user.setPassword(newPassWord);*/
        UserInfo login = userMapper.login(user);
        return login;
    }
    //注册的方法
    public Integer register(UserInfo user){
        int insert = userMapper.insert(user);
        return insert;
    }
    //校验的方法
    public String cheak(UserInfo userInfo){
        String msg = null;
        System.out.println(userInfo);
        //判断用户名
        if(userInfo.getName() != null){
            String name = userInfo.getName();//将用户名赋值给变量name
            if(name.equals("")){
                msg="用户名不能为空";
            }else{
                //用户名3到6位
                if(name.length()>3 && name.length()<6){
                    //开始搜索用户名
                    Integer cheak = userMapper.cheak(userInfo);
                    if(cheak>0){
                        msg="用户名已经存在";
                    }else{
                        msg="可以注册";
                    }
                }else{
                     msg="用户名必须在3到6位之间";
                }
            }
        }

        //判断手机号
        if(userInfo.getPhone() != null){
            if(userInfo.getPhone().equals("")){
                msg="手机号不能为空";
            }else{
                //再判断是不是手机号
                Pattern p = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$");
                Matcher m = p.matcher(userInfo.getPhone());
                if(m.matches()){
                    //开始搜索这个手机号是否注册过
                    Integer integer = userMapper.cheak(userInfo);
                    if(integer>0){
                        //说明手机号已经存在
                        msg="该手机号已经注册";
                    }else{
                        msg="手机号可用";
                    }
                }else{
                    msg="请输入正确的手机号";
                }
            }
        }

        //开始判断邮箱
        if (userInfo.getEmail() != null){
            String email = userInfo.getEmail();
            if(email.equals("")){
                msg="邮箱不能为空";
            }else{
                //开始邮箱校验
                Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
                Matcher m = p.matcher(userInfo.getEmail());
                if(m.matches()){
                    //开始搜索邮箱是否已经注册过了
                    Integer cheak = userMapper.cheak(userInfo);
                    if(cheak>0){
                        //说明邮箱已经存在
                        msg="邮箱已被注册";
                    }else{
                        msg="邮箱可以注册";
                    }
                }else{
                    msg="请输入正确的邮箱";
                }
            }
        }

        //开始检测密码
        if(userInfo.getPassword()!=null){
            String password = userInfo.getPassword();
            if(password.length()>6 && password.length()<9){
                msg="密码正确";
            }else{
                msg="密码必须在6到9位之间";
            }
        }
        return msg;
    }
}
