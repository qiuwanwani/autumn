package com.autumn.autuser.service;

import com.autumn.autuser.entity.AutUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * (AutUser)表服务接口
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:13:35
 */
@Service
public interface AutUserService extends IService<AutUser> {

    AutUser register(AutUser autUser);

    AutUser login(AutUser autUser);
}

