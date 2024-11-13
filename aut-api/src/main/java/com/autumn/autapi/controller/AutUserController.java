package com.autumn.autapi.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leafautumn.aut_user.entity.AutUser;
import com.leafautumn.aut_user.service.AutUserService;
import com.leafautumn.aut_user.util.ResultUtils;
import com.leafautumn.aut_user.util.SafeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * (AutUser)表控制层
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:13:32
 */
@RestController
@RequestMapping("autuser")
public class AutUserController {
    /**
     * 服务对象
     */
    private final AutUserService autUserService;

    public AutUserController(AutUserService autUserService) {
        this.autUserService = autUserService;
    }

    /**
     * 查询数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("select")
    public String selectOne(@RequestParam("id") Long id) {

        AutUser user = autUserService.getById(id);
        if (user == null) {
            return JSON.toJSONString(ResultUtils.fail("查询失败"));
        }
        // 用户信息脱敏
        AutUser safe = SafeUtils.getSafeUser(user);

        return JSON.toJSONString(ResultUtils.success(safe, "查询成功"));
    }

    /**
     * 查询所有数据+
     *
     * @return 所有数据
     */
    @GetMapping("selectall")
    public String selectAll() {
        List<AutUser> users = autUserService.list();
        users.forEach(user -> {
//            user.setAccount(EncryptUtils.decryptAccount(EncryptUtils.getAccount(user.getId()), user.getSalt(),
//                    EncryptUtils.encryptAccount(EncryptUtils.getAccount(user.getId()), user.getSalt())));
        });

        // 用户信息脱敏
        users.forEach(autUser -> {
            autUser.setId(null);
            autUser.setPassword(null);
            autUser.setSalt(null);
        });
        return JSON.toJSONString(ResultUtils.success(users, "查询成功"));
    }

    /**
     * 新增数据
     */

    @PostMapping("insert")
    public String insertOne(AutUser autUser) {
        // 新增id
        // 定义一个静态的QueryWrapper实例，避免每次调用都创建新的实例
        final QueryWrapper<AutUser> QUERY_WRAPPER = new QueryWrapper<AutUser>().orderByDesc("id");
        // 获取最新的用户ID
        AutUser lastUser = autUserService.getOne(QUERY_WRAPPER.last("limit 1"));
        // 如果没有找到用户，初始化lastUser的ID为0
        Long id = (lastUser != null) ? lastUser.getId() + 1 : 1L;


        return JSON.toJSONString(ResultUtils.success(autUserService.save(autUser), "新增成功"));
    }

    /**
     * 删除数据
     */
    @PostMapping("delete")
    public String deleteOne(@RequestParam("id") Integer id) {
        AutUser autUser = autUserService.getById(id);
        // 逻辑删除
        autUser.setDeleted(1);
        autUser.setUpdateTime(new Date());
        return JSON.toJSONString(ResultUtils.success(autUserService.updateById(autUser), "删除成功"));
    }

    /**
     * 修改数据
     */
    @PostMapping("update")
    public String updateOne(AutUser autUser) {
        autUser.setUpdateTime(new Date());
        return JSON.toJSONString(ResultUtils.success(autUserService.updateById(autUser), "修改成功"));
    }

    /**
     * 用户注册
     */
    @RequestMapping("register")
    public String register(AutUser autUser) {
        return JSON.toJSONString(ResultUtils.success(autUserService.register(autUser), "注册成功"));
    }

    /**
     * 用户登录
     */
    @RequestMapping("login")
    public String login(AutUser autUser) {
        return JSON.toJSONString(ResultUtils.success(autUserService.login(autUser), "登录成功"));
    }

}

