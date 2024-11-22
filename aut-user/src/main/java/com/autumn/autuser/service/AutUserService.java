package com.autumn.autuser.service;

import com.autumn.autuser.entity.AutUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AutUserService extends IService<AutUser>  {
    AutUser getUserById(Long id);
}
