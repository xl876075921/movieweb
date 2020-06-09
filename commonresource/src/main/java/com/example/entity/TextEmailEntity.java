package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.entity
 * @Author: 闫靖方
 * @CreateTime: 2020-06-02 15:04
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextEmailEntity {
    private String to;
    private String content;
    public static TextEmailEntity setToAndText(String to,String content){
        TextEmailEntity textEmailEntity = new TextEmailEntity();
        textEmailEntity.setTo(to);
        textEmailEntity.setContent(content);
        return textEmailEntity;
    }
}
