package com.autumn.autcommon.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @program: autumn
 * @ClassName EncryptUtils
 * @author: 秋晚河岸的风
 * @since 2024-10-22 17:06:21
 **/
public class EncryptUtils {
    // 获取账号
    public static String getAccount(Long id) {
        // 起始账号
        int baseAccount = 100000000;
        // 计算账号
        int account = baseAccount + id.intValue();
        // 转换为字符串并返回
        return String.valueOf(account);
    }

    // 加密
    public static String encrypt(String pass, String salt) {
        String md5pass = DigestUtils.md5DigestAsHex(pass.getBytes(StandardCharsets.UTF_8));
        String stack = salt + md5pass;
        return DigestUtils.md5DigestAsHex(stack.getBytes(StandardCharsets.UTF_8));
    }

    // 解密
    public static String decrypt(String pass, String salt, String encrypted) {
        if (encrypt(pass,salt).equals(encrypted)) {
            return pass;
        } else
            return null;
    }

    public static String getUUid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
