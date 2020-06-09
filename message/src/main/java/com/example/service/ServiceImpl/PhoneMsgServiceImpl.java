package com.example.service.ServiceImpl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.service.PhoneMsgService;
import com.example.service.PhoneMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.service.ServiceImpl
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 23:37
 * @Description:
 */
@Service
public class PhoneMsgServiceImpl implements PhoneMsgService {
    @Autowired
    RedisServiceImpl redisService;
    public void sendPhoneMsg(String phoneNum){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G5ARBkd9j8nV1BZv23V", "gOK4GoDI1yeDxZjpuf8I5DGhkAQqya");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "蜗牛课堂");
        request.putQueryParameter("TemplateCode", "SMS_192230582");
        Random random = new Random();
        int num = random.nextInt(999999);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+num+"\"}");
        System.out.println(num);
        try {
            CommonResponse response = client.getCommonResponse(request);
            boolean isSuccess = response.getData().indexOf("OK")>-1;
            redisService.setExpire(phoneNum,num+"",1000*60*3);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
