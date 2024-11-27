package com.autumn.autuser.service.impl;

import com.autumn.autuser.entity.AutUser;
import com.autumn.autuser.mapper.AutUserMapper;
import com.autumn.autuser.service.AutUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("autUserService")
public class AutUserServiceImpl extends ServiceImpl<AutUserMapper, AutUser> implements AutUserService {

}
