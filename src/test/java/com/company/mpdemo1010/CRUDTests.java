package com.company.mpdemo1010;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.mpdemo1010.entity.User;
import com.company.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author wlb10
 * @PackageName mpdemo1010
 * @Package com.company.mpdemo1010
 * @Date 2022/7/27 22:45
 * @Version 1.0
 */
@SpringBootTest
public class CRUDTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("东方不败");
        user.setAge(180);
        user.setEmail("55317332@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("影响的行数：" + insert);
        System.out.println("id自动回填：" + user);
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1552436110783688706L);
        user.setAge(28);
        int result = userMapper.updateById(user);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testOptimisticLocker() {
        /**
         * @Description:测试乐观锁先查询在修改
         * @Author: wlb
         * @Date: 2022/7/28 7:33
         * @param
         * @return:void
         */
        //查询
        User user = userMapper.selectById(1552436110783688706L);
        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage(){
        //1.创建分页对象，传入当前页和页大小
        Page<User> page = new Page<>(1,5);
        //2.调用mp分页查询方法,封装所有的数据到page对象里面
        userMapper.selectPage(page, null);
        List<User> records = page.getRecords();
        System.out.println(records);
        //3.通过page对象获取分页数据
        System.out.println("当前页:" + page.getCurrent());
        System.out.println("页数：:" + page.getPages());
        System.out.println("页大小:" + page.getSize());
        System.out.println("总记录数:" + page.getTotal());
        System.out.println("下一页:" + page.hasNext());
        System.out.println("上一页:" + page.hasPrevious());
    }

    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1552515375390892034L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }

    @Test
    public void testPerformance() {
        User user = new User();
        user.setName("我是Helen");
        user.setEmail("helen@sina.com");
        user.setAge(18);
        userMapper.insert(user);
    }
}
