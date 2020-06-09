package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn
 * @Author: 闫靖方
 * @CreateTime: 2020-06-01 17:53
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRsp {
    private int code;
    private String msg;
    private Object content;
    public static MyRsp success(Object content){
        MyRsp myRsp = new MyRsp();
        myRsp.setMsg("请求成功");
        myRsp.setCode(20000);
        myRsp.setContent(content);
        return myRsp;
    }
    public MyRsp msg(String msg){
        this.setMsg(msg);
        return this;
    }
    public MyRsp code(int code){
        this.setCode(code);
        return this;
    }
    public static MyRsp fail(){
        MyRsp myRsp = new MyRsp();
        myRsp.setMsg("访问失败");
        myRsp.setContent(null);
        myRsp.setCode(50000);
        return myRsp;
    }
}
