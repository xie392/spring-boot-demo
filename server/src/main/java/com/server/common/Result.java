package com.server.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    private String msg;

    public static <T> Result<T> success(T data) {
        return new Result<T>(200, data, "success");
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        return new Result<T>(code, data, msg);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<T>(200, data, msg);
    }

    public static <T> Result<T> error(T data) {
        return new Result<T>(500, data, "error");
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(500, null, msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, null, msg);
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        return new Result<T>(code, data, msg);
    }

}
