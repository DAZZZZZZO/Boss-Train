package com.bosssoft.hr.train.j2se.pojo.entity.collection;

import com.bosssoft.hr.train.j2se.pojo.entity.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @version 1.0
 * @class: TreeSetDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午8:13
 */
@Slf4j
public class TreeSetDemo extends BaseCollectionDemo {

    private TreeSet<User> userTreeSet = new TreeSet<>();

    public void sortResult(){
        User[] users = generateDate();
        for (User user : users){
            log.info("用户信息：" ,user);
        }
    }
}
