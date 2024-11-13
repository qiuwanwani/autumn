package com.autumn.autuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leafautumn.aut_user.entity.AutUser;
import com.leafautumn.aut_user.mapper.AutUserMapper;
import com.leafautumn.aut_user.service.AutUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * (AutUser)表服务实现类
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:13:35
 */
@Slf4j
@Service("autUserService")
public class AutUserServiceImpl extends ServiceImpl<AutUserMapper, AutUser> implements AutUserService {
    /**
     * 用户注册
     *
     * @param autUser
     * @return
     */
    @Override
    public AutUser register(AutUser autUser) {
        // 新增id
        final QueryWrapper<AutUser> QUERY_WRAPPER = new QueryWrapper<AutUser>().orderByDesc("id");
        AutUser lastUser = this.getOne(QUERY_WRAPPER.last("limit 1"));
        Long id = (lastUser != null) ? lastUser.getId() + 1 : 1L;
        autUser.setId(id);
        // 新增账号
        // autUser.setAccount(AccountUtils.encryptAccount(String.valueOf(id)));
        // 新增Uid
        // autUser.setUid(UidUtils.getUUid());

        // 创建时间
        autUser.setCreateTime(new Date());
        // 更新时间
        autUser.setUpdateTime(new Date());
        return this.save(autUser) ? autUser : null;
    }
    @Override
    public AutUser login(AutUser autUser) {
        return null;
    }
}

