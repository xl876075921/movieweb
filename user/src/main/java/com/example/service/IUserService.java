package com.example.service;

import com.example.pojo.UserInfo;

/**
 * @BelongsProject: movieweb
 * @BelongsPackage: com.wn.Service
 * @Author: 闫靖方
 * @CreateTime: 2020-06-09 10:55
 * @Description:
 */
public interface IUserService {
    UserInfo login(UserInfo userInfo);
    Integer register(UserInfo userInfo);
}
