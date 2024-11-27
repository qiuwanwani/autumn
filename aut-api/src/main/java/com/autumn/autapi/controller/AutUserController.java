package com.autumn.autapi.controller;

import com.autumn.autcommon.util.Result;
import com.autumn.autuser.entity.AutUser;
import com.autumn.autuser.service.AutUserService;
import com.autumn.autuser.vo.UserDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
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
     *
     * @return AutUser
     */
    @PostMapping("/select")
    public Result select(@RequestParam("id") Long id) {
        AutUser autUser = autUserService.getById(id);
        UserDetailVO userDetailVO = new UserDetailVO();
        BeanUtils.copyProperties(autUser, userDetailVO);
        return Result.success(userDetailVO);
    }
    /**
     * 根据id查询所有
     * @return AutUser
     */
    @PostMapping("/select/all")
    public String selectAll() {
        List <AutUser> autUserList = autUserService.list();
        return autUserList.toString();
    }
}