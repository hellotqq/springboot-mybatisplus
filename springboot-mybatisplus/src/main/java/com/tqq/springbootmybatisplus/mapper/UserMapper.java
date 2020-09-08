package com.tqq.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tqq.springbootmybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author ： tqq
 * @date ： 2020/9/8 23:14
 * @Description:
 */

/**
 * 对应的mapper上面继承基本的类 BaseMapper
 * 代表持久层
 * @author tqq
 */
@Repository
public interface UserMapper  extends BaseMapper<User> {
}
