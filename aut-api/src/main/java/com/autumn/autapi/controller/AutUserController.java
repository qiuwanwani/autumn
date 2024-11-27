package com.autumn.autapi.controller;

import com.autumn.autcommon.util.Result;
import com.autumn.autuser.entity.AutUser;
import com.autumn.autuser.service.AutUserService;
import com.autumn.autuser.util.NameUtils;
import com.autumn.autuser.util.NumsUtils;
import com.autumn.autuser.util.PasswordUtils;
import com.autumn.autuser.vo.UserDetailVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class AutUserController {
    /**
     * 服务对象
     */
    private final AutUserService autUserService;

    public AutUserController(AutUserService autUserService) {
        this.autUserService = autUserService;
    }

    /**
     * 根据id查询用户
     * @return AutUser
     */
    @PostMapping("select")
    public Result<UserDetailVO> select(@RequestParam("id") Long id) {
        AutUser autUser = autUserService.getById(id);
        UserDetailVO userDetailVO = new UserDetailVO();
        BeanUtils.copyProperties(autUser, userDetailVO);
        return Result.success(userDetailVO);
    }

    /**
     * 根据id查询所有
     * @return AutUser
     */
    @PostMapping("select/all")
    public Result<List<UserDetailVO>> selectAll() {
        List<AutUser> autUserList = autUserService.list();
        List<UserDetailVO> userDetailVOList = new ArrayList<>();

        // 遍历autUserList，将每个AutUser对象转换为UserDetailVO对象
        for (AutUser autUser : autUserList) {
            UserDetailVO userDetailVO = new UserDetailVO();
            BeanUtils.copyProperties(autUser, userDetailVO);
            userDetailVOList.add(userDetailVO);
        }

        // 返回包含所有UserDetailVO对象的列表
        return Result.success(userDetailVOList);
    }

    /**
     * 增加用户
     * @return AutUser
     */
    @PostMapping("add")
    public Result<Boolean> add(AutUser autUser) {
        // 定义一个静态的QueryWrapper实例，避免每次调用都创建新的实例
        final QueryWrapper<AutUser> QUERY_WRAPPER = new QueryWrapper<AutUser>().orderByDesc("id");
        // 获取最新的用户ID
        AutUser lastUser = autUserService.getOne(QUERY_WRAPPER.last("limit 1"));
        // 如果没有找到用户，初始化lastUser的ID为0
        Long id = (lastUser != null) ? lastUser.getId() + 1 : 1L;
        autUser.setId(id);
        // 新增名字
        autUser.setName(NameUtils.getCnName());
        // 新增账号
        autUser.setAccount(NumsUtils.getAccount(autUser.getId()));
        // 新增密码
        autUser.setPassword(PasswordUtils.encode(autUser.getPassword()));

        return Result.success(autUserService.save(autUser));
    }
}