package com.example.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jack
 * @date 2018/4/24 4 16:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisAutoTest {
    @Autowired
    private StringRedisTemplate template;

    @Test
    public void save(){
        template.opsForValue().set("name","Aslan");
        Assert.assertEquals("Aslan",template.opsForValue().get("name"));
    }
}
