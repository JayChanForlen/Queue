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

    /**
     * 下面记录大神写的关于循环队列的出入方式，值得借鉴
     * 主要区别是通过增位后的取余的哈希来进行位置的切换
     * ，也就是说，我其实对哈希算法的使用场景是受定势思维限制的，如果我没法在短时间内将思维开拓，我就要记住这种算法使用场景
     */
    // 入队
    public boolean _enqueue(T item) {
        // 队列满了
        if ((tail + 1) % count == head) {
            return false;
        }
        data[tail] = item;
        tail = (tail + 1) % count;
        return true;
    }

    // 出队
    public T _dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        T ret = (T)data[head];
        head = (head + 1) % count;
        return ret;
    }

    public void printAll() {
        if (0 == count) {
            return;
        }
        for (int i = head; i % count != tail; i = (i + 1) % count) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
