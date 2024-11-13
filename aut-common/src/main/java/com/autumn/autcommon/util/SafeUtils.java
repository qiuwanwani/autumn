package com.autumn.autcommon.util;

import com.leafautumn.aut_user.entity.AutUser;

/**
 * @program: autumn
 * @ClassName SafeUtils
 * @author: 秋晚河岸的风
 * @since 2024-10-22 12:16:22
 **/
public class SafeUtils {
    /***
     * 获取安全用户
     * @param originUser
     * @return
     */
    public static AutUser getSafeUser(AutUser originUser) {
        AutUser safe = new AutUser();
        safe.setName(originUser.getName());
        safe.setAccount(originUser.getAccount());
        safe.setAvatar(originUser.getAvatar());
        safe.setGender(originUser.getGender());
        safe.setEmail(originUser.getEmail());
        safe.setPhone(originUser.getPhone());
        safe.setDeleted(originUser.getDeleted());
        safe.setCreateTime(originUser.getCreateTime());
        safe.setUpdateTime(originUser.getUpdateTime());
        safe.setAdmin(originUser.getAdmin());
        return safe;
    }
}
