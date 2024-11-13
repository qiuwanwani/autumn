package com.autumn.autuser.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (AutUser)表实体类
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:13:35
 */
@Data
@TableName("aut_user")
public class AutUser extends Model<AutUser> {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否删除
     * 0:未删除 1:已删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否管理员
     * 0:普通用户 1:管理员
     */
    private Integer admin;

    /**
     * 盐值
     */
    private String salt;
}

