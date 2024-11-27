package com.autumn.autcommon.util;

import cn.hutool.core.util.ObjectUtil;
import com.autumn.autcommon.constant.ResponseCodeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 */
@ToString
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private int code = ResponseCodeConstants.SUCCESS;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        return restResult(null, ResponseCodeConstants.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return restResult(data, ResponseCodeConstants.SUCCESS, null);
    }

    public static <T> Result<T> success(T data, String msg) {
        return restResult(data, ResponseCodeConstants.SUCCESS, msg);
    }

    public static <T> Result<T> isSuccess(boolean flag) {
        return flag ? success() : failed();
    }

    public static <T> Result<T> failed() {
        return restResult(null, ResponseCodeConstants.FAIL, null);
    }


    public static <T> Result<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, ResponseCodeConstants.FAIL, msg);
    }

    public static <T> Result<T> failed(String msg, T data) {
        return restResult(data, ResponseCodeConstants.FAIL, msg);
    }


    public static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


    @JsonIgnore
    public Boolean isDataNull() {
        return ObjectUtil.isNull(data);
    }

}


