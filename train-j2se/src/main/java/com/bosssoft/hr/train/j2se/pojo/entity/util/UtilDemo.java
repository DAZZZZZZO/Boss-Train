package com.bosssoft.hr.train.j2se.pojo.entity.util;

import com.aliyuncs.utils.StringUtils;
import com.bosssoft.hr.train.j2se.pojo.entity.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @class: UtilDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午9:45
 */
@Slf4j
public class UtilDemo {
    public static void method1(){
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        log.info(String.valueOf(list));
    }

    public static void method2(){
        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(CollectionUtils.isEmpty(list2));

        List<String> list3 = new ArrayList<>(Arrays.asList("d", "e", "f"));
        List<String> list4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        CollectionUtils.addAll(list4, list3);
        System.out.println(list4); 

        System.out.println(CollectionUtils.exists(list4, s -> s.equals("a")));
        System.out.println(CollectionUtils.exists(list4, s -> s.equals("g")));
    }

    public static void method3() {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2};
        List<Integer> list = Arrays.asList(arr);

        Object[] scoreChange=list.toArray();
        Arrays.sort(scoreChange);
        int index = Arrays.binarySearch(scoreChange, 4);
        Integer[] copyArray=Arrays.copyOf(arr,3);
    }

    public static void method4() {
        File directory = new File("src/main/resources");
        File[] files = FileUtils.listFiles(directory, null, false).toArray(new File[0]);
        for (File file : files) {
            log.info(file.getName());
        }
    }

    public static void method5() {
        String str1 = "";
        String str2 = null;
        String str3 = "abc";
        log.info(String.valueOf(StringUtils.isEmpty(str1)));
        log.info(String.valueOf(StringUtils.isEmpty(str2)));
        log.info(String.valueOf(StringUtils.isEmpty(str3)));
    }
    public static void method6() throws Exception {
        User user1 = new User(18, "Tom");
        User user2 = new User();
        BeanUtils.copyProperties(user2, user1);
        System.out.println(user2.getName() + " " + user2.getAge()); // Tom 18
    }

    public static void method7() {
        String str = "hello world";
        String md5 = DigestUtils.md5Hex(str);
        log.info(md5);
    }

    public static void method8() {
        String str = "hello world";
        String sha256 = DigestUtils.sha256Hex(str);
        log.info(sha256);
    }
}
