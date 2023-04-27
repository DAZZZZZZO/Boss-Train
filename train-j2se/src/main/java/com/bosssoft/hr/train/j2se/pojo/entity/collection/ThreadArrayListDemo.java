package com.bosssoft.hr.train.j2se.pojo.entity.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @class: ThreadArrayListDemo
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023
 */
@Slf4j
public class ThreadArrayListDemo {
    private List<String> productList = new ArrayList<>();

    /**
     *  生产者线程
     */
    public class ProducerThread extends Thread {
        private List<Integer> list;
        private int maxSize = 5;
        private int i = 0;

        public ProducerThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == maxSize) {
                        try {
                            log.info("队列已满，等待消费者消费...");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }

                    log.info("生产者生产了数据：" + i);
                    list.add(i++);
                    list.notifyAll();
                }
            }
        }
    }

    /**
     * 消费者线程
     */
    public class ConsumerThread extends Thread {
        private List<Integer> list;

        public ConsumerThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            log.info("队列为空，等待生产者生产...");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }

                    int data = list.remove(list.size() - 1);
                    log.info("消费者消费了数据：" + data);
                    list.notifyAll();
                }
            }
        }
    }
}
