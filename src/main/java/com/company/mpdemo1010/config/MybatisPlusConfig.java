package com.company.mpdemo1010.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author wlb10
 * @PackageName mpdemo1010
 * @Package com.company.mpdemo1010.config
 * @Date 2022/7/28 1:16
 * @Version 1.0
 */
@EnableTransactionManagement  //开启事务操作
@Configuration
@MapperScan("com.company.mpdemo1010.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //添加乐观锁插件
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //添加分页插件,别忘记设置数据库的类型
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }

    //@Bean
    //@Profile({"dev","test"})// 设置 dev test 环境开启
    //public PerformanceInterceptor performanceInterceptor() {
    //    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    //    performanceInterceptor.setMaxTime(100);//ms，超过此处设置的ms则sql不执行
    //    performanceInterceptor.setFormat(true);
    //    return performanceInterceptor;
    //}

}
