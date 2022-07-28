package com.company.mpdemo1010;

import com.company.mpdemo1010.entity.User;
import com.company.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName mpdemo1010
 * @Package com.company.mpdemo1010
 * @Date 2022/7/27 22:32
 * @Version 1.0
 */
@SpringBootTest
public class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        System.out.println("=================selectAll method test=================");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
