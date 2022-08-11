package com.bootcamp.userService.userService.service.redis;

import com.bootcamp.userService.userService.entity.BootCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private ReactiveRedisOperations<String, BootCustomer> userOps;

    public void saveUser(String key, BootCustomer bootCustomer){
        ReactiveValueOperations<String, BootCustomer> ops = userOps.opsForValue();
        ops.set(key, bootCustomer).subscribe();
    }
}
