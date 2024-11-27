package com.autumn.autuser.util;

import java.util.UUID;

public class NumsUtils {
    /**
     * 生成随机盐值
     * @return
     */
    public static String getSalt(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成账号
     * @return
     */
    public static String getAccount(Long id) {
        // 起始账号
        int baseAccount = 100000000;
        // 计算账号
        int account = baseAccount + id.intValue();
        // 转换为字符串并返回
        return String.valueOf(account);
    }

}