package com.yangwang.application.pet.market.service.spring.queue;

import java.lang.reflect.Array;

/**
 * <p>
 * 任务队列
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className TaskQueue
 * @date 2020/4/26 10:50
 **/
public class TaskQueue<E> {
    /**
     * 队列数组
     */
    private E[] queue;
    /**
     * 队头位置
     */
    private int front;
    /**
     * 队尾位置
     */
    private int area;
    /**
     * 数组长度
     */
    private int maxSize;

    /**
     * <p>
     * 创建一个指定大小的队列
     * </p>
     *
     * @param size 数组大小
     * @return
     * @author LiuXiangLin
     * @date 10:51 2020/4/26
     **/
    public TaskQueue(Class<E> eClass, int size) {
        if (size < 1) {
            throw new RuntimeException("数组长度不能为小于1");
        }
        // 为了可以循环使用该队列，需要空出一个位置
        this.maxSize = size + 1;

        // 初始化对头以及队尾位置
        this.front = 0;
        this.area = 0;

        // 创建一个泛型数组
        queue = (E[]) Array.newInstance(eClass, maxSize);
    }

    /**
     * <p>
     * 入列一个元素
     * </p>
     *
     * @param e 元素对象
     * @return boolean
     * @author LiuXiangLin
     * @date 11:01 2020/4/26
     **/
    public boolean enqueue(E e) {
        if (isFull()) {
            return false;
        }
        // 将元素添加到队尾
        queue[area] = e;

        // 如果到达对尾则跳转到队头
        area = (area + 1) % maxSize;

        return true;
    }

    /**
     * <p>
     * 出列一个元素
     * </p>
     *
     * @param
     * @return E
     * @author LiuXiangLin
     * @date 11:03 2020/4/26
     **/
    public E deQueue() {
        // 空判断
        if (isEmpty()) {
            return null;
        }

        // 获取头部元素
        E e = queue[front];

        // 将该元素设为空
        queue[front] = null;

        // 头部向后移动一位
        front = (front + 1) % front;

        return e;
    }


    /**
     * <p>
     * 队列是否为空
     * </p>
     *
     * @param
     * @return boolean
     * @author LiuXiangLin
     * @date 11:03 2020/4/26
     **/
    public boolean isEmpty() {
        return area == front;
    }

    /**
     * <p>
     * 队列是否已满
     * </p>
     *
     * @param
     * @return boolean
     * @author LiuXiangLin
     * @date 11:04 2020/4/26
     **/
    public boolean isFull() {
        return getQueueSize() == maxSize - 1;
    }

    /**
     * <p>
     * 获取队列的当前长度
     * </p>
     *
     * @param
     * @return int
     * @author LiuXiangLin
     * @date 11:07 2020/4/26
     **/
    public int getQueueSize() {
        return (area - front + maxSize) % maxSize;
    }
}
