package cn.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("getUsername")
    public String getUsername(){
        return stringRedisTemplate.opsForValue().get("username");
    }

}
