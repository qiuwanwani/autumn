package com.autumn.autuser.vo;

import lombok.Data;

import java.util.Date;
@Data
public class UserDetailVO {
    /**
     * 主键
     */
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

}
