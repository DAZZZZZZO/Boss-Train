package com.bosssoft.hr.train.j2se.pojo.entity.exception;

/**
 * @version 1.0
 * @class: BusinessException
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午9:12
 */
public class BusinessException extends RuntimeException {
    private ExceptionCode exceptionCode;

    public BusinessException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }
}
