package com.bosssoft.hr.train.j2se.pojo.entity.stream;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @class: StreamDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午10:56
 */
@Slf4j
public class StreamDemo {


    public static List<User> createUserList() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Helen", "Ivy", "John"};
        Random random = new Random();
        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            String name = names[random.nextInt(names.length)];
            LocalDate birthday = LocalDate.of(1990 + random.nextInt(10), random.nextInt(12) + 1, random.nextInt(28) + 1);
            User user = new User(name, birthday);
            users[i] = user;
        }
        return Arrays.asList(users);
    }

    public static class User {
        private String name;
        private LocalDate birthday;

        public User(String name, LocalDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }

        public int getAge() {
            return LocalDate.now().getYear() - birthday.getYear();
        }
    }

    public static void testStreamApply(List<User> users) {
        List<User> filteredUsers = users.stream()
                .filter(u -> u.getAge() > 30)
                .sorted((u1, u2) -> u1.getAge() - u2.getAge())
                .map(u -> new User(u.getName(), u.getBirthday().plusYears(1)))
                .collect(Collectors.toList());
        log.info(String.valueOf(filteredUsers));
    }

    static class Main {

        public static void main(String[] args) {
            List<StreamDemo.User> userList = StreamDemo.createUserList();
            log.info(String.valueOf(userList));
        }
    }
}




