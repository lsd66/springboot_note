package com.lsd.springboot_learning.exception;

import com.lsd.springboot_learning.base.ResultCode;

public class BizException extends RuntimeException{
    private Integer code;

    public BizException(){
    }

    public BizException(String message){
        super(message);
    }

    public BizException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public BizException(ResultCode resultCode){
        super(resultCode.getMsg());
        this.code=resultCode.getCode();
    }

    public BizException(String message,Throwable cause){
        super(message, cause);
        this.code=code;
    }

    public BizException(ResultCode resultCode,Throwable cause){
        super(resultCode.getMsg(),cause);
        this.code=resultCode.getCode();
    }

    public Integer getCode(){
        return this.code;
    }

    public void setCode(Integer code){
        this.code=code;
    }
}
