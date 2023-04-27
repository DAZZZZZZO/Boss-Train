package com.bosssoft.hr.train.j2se.pojo.entity.collection;

import com.bosssoft.hr.train.j2se.pojo.entity.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @class: BaseCollectionDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午4:47
 */
public class BaseCollectionDemo {

    private static final int MAX_LOOP_COUNT = 10;

    protected User[] generateDate() {
        User[] users=new User[MAX_LOOP_COUNT];
        for(int i=1;i<=MAX_LOOP_COUNT;i++){
            // 字段较多构建简单字段满足作业要求即可
            users[i]=new User(
                    new Long(i),
                    String.format("BS%03d",i),
                    "同学"+i
            );
        }
        return users;


    }
}
