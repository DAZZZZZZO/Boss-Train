package com.bosssoft.hr.train.j2se.pojo.entity.exception;

/**
 * @version 1.0
 * @class: ExceptionCode
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午9:26
 */
public enum ExceptionCode {

    SUCCESS("0000", "操作成功"),
    PARAMETER_ERROR("0001", "参数错误"),
    SYSTEM_ERROR("0002", "系统异常");

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
