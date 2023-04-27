package com.bosssoft.hr.train.j2se.pojo.entity.collection;

import com.bosssoft.hr.train.j2se.pojo.entity.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @version 1.0
 * @class: HashSetDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午7:06
 */

@Slf4j
public class HashSetDemo extends BaseCollectionDemo {
    Set<User> userHashSet = new HashSet<>();

    public void SaveUsers() {

        User[] users = generateDate();
        for (User user : users) {
            userHashSet.add(user);
        }


        Iterator<User> iterator = userHashSet.iterator();
        while (iterator.hasNext()) {
            log.info("当前用户：", iterator.next());
        }
    }

}
