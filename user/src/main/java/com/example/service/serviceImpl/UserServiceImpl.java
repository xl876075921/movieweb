package com.example.service.serviceImpl;

import com.example.mapper.UserInfoMapper;
import com.example.pojo.UserInfo;
import com.example.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: movieweb
 * @BelongsPackage: com.example.service.serviceImpl
 * @Author: 闫靖方
 * @CreateTime: 2020-06-09 11:14
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    private UserInfoMapper userMapper;
    @Override
    public UserInfo login(UserInfo user) {
        /*Md5Hash md5Hash = new Md5Hash(user.getPassword(), "com.woniu", 5);
        String newPassWord = md5Hash.toString();
        user.setPassword(newPassWord);*/
        UserInfo login = userMapper.login(user);
        return login;
    }
}
