package com.example.controller;

import com.example.entity.MyParam;
import com.example.entity.MyRsp;
import com.example.entity.PhoneMsgEntity;
import com.example.service.ServiceImpl.PhoneMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.controller
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 23:20
 * @Description:
 */
@RestController
public class PhoneMsgController {
    @Autowired
    PhoneMsgServiceImpl phoneMsgService;


    @RequestMapping(value = "/sendPhoneMsg", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public MyRsp sendPhoneMsg(@RequestBody MyParam<PhoneMsgEntity> param) {
        System.out.println(param);
        phoneMsgService.sendPhoneMsg(param.getT().getPhoneNum());
        return MyRsp.success("发送成功");
    }
}
