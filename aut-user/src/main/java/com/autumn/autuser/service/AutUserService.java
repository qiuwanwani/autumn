package com.autumn.autuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leafautumn.aut_user.entity.AutUser;

/**
 * (AutUser)表服务接口
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:13:35
 */
public interface AutUserService extends IService<AutUser> {

    AutUser register(AutUser autUser);

    AutUser login(AutUser autUser);
}

