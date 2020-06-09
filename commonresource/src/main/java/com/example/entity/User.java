package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.entity
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 22:47
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
