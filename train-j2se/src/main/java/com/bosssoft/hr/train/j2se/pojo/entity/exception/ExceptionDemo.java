package com.bosssoft.hr.train.j2se.pojo.entity.exception;

import static com.bosssoft.hr.train.j2se.pojo.entity.exception.ExceptionCode.SYSTEM_ERROR;

/**
 * @version 1.0
 * @class: ExceptionDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午9:14
 */
public class ExceptionDemo {
    /**
     * 测试异常
     * @param args
     */
    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        exceptionDemo.method1();

        try {
            exceptionDemo.method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 自定义异常
     */
    public void method1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            BusinessException be = new BusinessException("系统异常", SYSTEM_ERROR, e);
        }
    }

    public void method2() throws Exception {
        try {

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
