package com.company.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author wlb10
 * @PackageName mpdemo1010
 * @Package com.company.mpdemo1010.entity
 * @Date 2022/7/27 22:29
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
