package com.autumn.autuser.service.impl;

import com.autumn.autuser.entity.AutUser;
import com.autumn.autuser.mapper.AutUserMapper;
import com.autumn.autuser.service.AutUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class AutUserServiceImpl extends ServiceImpl<AutUserMapper, AutUser> implements AutUserService {
    /**
     * 根据id查询用户信息
     */
    @Override
    public AutUser getUserById(Long id) {
        return this.getById(id);
    }
}
