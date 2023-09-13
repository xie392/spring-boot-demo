package com.server;

import com.server.sys.entity.User;
import com.server.sys.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ServerApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void testUserMapper() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }


}
