package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.entity
 * @Author: 闫靖方
 * @CreateTime: 2020-06-01 17 :54
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private String summary;
    private Date createTime;
}
