package com.tqq.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tqq.springbootmybatisplus.mapper.UserMapper;
import com.tqq.springbootmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ： tqq
 * @date ： 2020/9/9 15:09
 * @Description:
 */
@SpringBootTest
public class TestWapper {
    @Autowired
    UserMapper userMapper;
    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询年龄大于12
        wrapper.ge("age",12);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询名字 伟哥
        wrapper.eq("name","伟哥");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询年龄在1-10岁之间的用户
        wrapper.between("age",1,10);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id在子查询中查出来
        wrapper.inSql("id","select id from user where id<6");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过age进行排序
        wrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
