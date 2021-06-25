/**
 * @description:
 * 1、构建长度固定的数组作为环形队列的存储
 * 2、加入：
 *      判断队列是否为满队列
 *      判断是否为空队列
 *      进行入队列
 *      判断是否需要将tail进行归零
 * 3、取出：
 *      判断队列是否为满队列
 *      判断是否为空队列
 *      进行出队列
 *      判断是否需要将head进行归零
 * @author: JayChan
 * @date: 2021/6/25
 * @time: 5:02 下午
 * Copyright (C) 2015 xxx
 * All rights reserved
 */
public class CircularQueue<T> {

    private Object[] data;
    private int head;
    private int tail;
    private int count;

    public CircularQueue(int count) {
        data = new Object[count];
        this.count = count;
    }

    public boolean enqueue(T item){
        if (head == tail){
            if (data[head] != null){
                System.out.println("queue is full");
                return false;
            }
        }

        data[tail] = item;
        if (tail+1 == count) {
            tail = 0;
        }else{
            tail++;
        }

        return true;
    }

    public T dequeue(){
        if (head == tail){
            if (data[head] == null){
                System.out.println("queue is null");
                return null;
            }
        }
        T t = (T)data[head];
        data[head] = null;
        if (head+1 == count){
            head = 0;
        }else {
            head++;
        }
        return t;
    }

}
