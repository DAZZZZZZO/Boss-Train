package com.bosssoft.hr.train.j2se.pojo.entity.collection;

import com.bosssoft.hr.train.j2se.pojo.entity.pojo.User;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Constraint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @version 1.0
 * @class: HashMapDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午6:12
 */

@Slf4j
public class HashMapDemo extends BaseCollectionDemo {

    private Map<Long, User> userHashMap = new HashMap<>();

    public void visitByEntrySet() {
        User[] users = generateDate();
        for (User user : users) {
            userHashMap.put(user.getId(), user);
        }

        Set<Map.Entry<Long, User>> setUser = userHashMap.entrySet();
        if (null == setUser) {
            throw new RuntimeException("不存在数据");
        }

        for (Map.Entry<Long, User> entry : setUser) {
            log.info("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }

}
