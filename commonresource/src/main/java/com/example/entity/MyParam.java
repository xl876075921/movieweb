package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.entity
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 10:13
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyParam<T>{
    private MyPage pageParam;
    private String[] orderParam;
    private T t;
}
