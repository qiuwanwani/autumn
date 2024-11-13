package com.autumn.autcommon.util;

import com.leafautumn.aut_user.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果类
 *
 * @author 秋晚河岸的风
 * @since 2024-10-15 16:33:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUtils {
    private int code;
    private String message;
    private Object data;

    public static ResultUtils success(Object data, String Message) {
        return new ResultUtils(Result.SUCCESS.getCode(), Message, data);
    }

    public static ResultUtils fail(String message) {
        return new ResultUtils(Result.FAIL.getCode(), message, null);
    }
}
