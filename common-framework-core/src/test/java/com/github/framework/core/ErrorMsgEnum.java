package com.github.framework.core;

import com.github.framework.core.exception.IError;

public enum ErrorMsgEnum implements IError {


    EX_SYSTEM_ERROR("00001","系统错误");


    private String code;
    private String message;

    ErrorMsgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
