package com.example.entity;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.entity
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 10:08
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPage {
    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
}
