package com.tqq.springbootmybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tqq.springbootmybatisplus.mapper.UserMapper;
import com.tqq.springbootmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);

    }
    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("hh");
        user.setAge(25);
        System.out.println(userMapper.insert(user));

    }
    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setName("伟哥");
        user.setAge(30);
        //注意：updateById的参数是一个对象
        System.out.println(userMapper.updateById(user));

    }
    //测试查询
    @Test
    public void testSelectById(){
        System.out.println(userMapper.selectById(1));
    }
    //测试批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    //测试多条件查询使用map
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","tqq");
        map.put("age",22);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //测试多条件查询使用map
    @Test
    public void testPage(){
        /**
         * 参数一：当前页
         * 参数二：页面大小
         */
        Page<User> page = new Page<>(1, 2);
       userMapper.selectPage(page,null);
       page.getRecords().forEach(System.out::println);
    }
    //测试删除
    @Test
    public void testDeleteById(){
        System.out.println(userMapper.deleteById(1));
    }
    //通过id批量删除
    @Test
    public void testDeleteBatchIds(){
        System.out.println(userMapper.deleteBatchIds(Arrays.asList(8,10,11)));
    }
    //通过map多条件（AND）删除
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","ttt");
        map.put("age",22);
        userMapper.deleteByMap(map);
    }
}
