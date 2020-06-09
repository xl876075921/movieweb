package com.example.service.ServiceImpl;

import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: cloud-base-wn1
 * @BelongsPackage: com.wn.service.ServiceImpl
 * @Author: 闫靖方
 * @CreateTime: 2020-06-03 23:26
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void setExpire(String key, String value, long expire) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expire, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
