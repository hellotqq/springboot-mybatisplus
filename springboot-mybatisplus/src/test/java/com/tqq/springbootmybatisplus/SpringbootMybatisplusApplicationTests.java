package com.tqq.springbootmybatisplus;

import com.tqq.springbootmybatisplus.mapper.UserMapper;
import com.tqq.springbootmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
        System.out.println(1);

    }

}
