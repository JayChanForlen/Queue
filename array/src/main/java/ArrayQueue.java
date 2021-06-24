/**
 * @description:
 *  1、首先需要清楚队列结构
 *  2、清楚队列中加元素和减元素之间，下标的移动是怎么样的
 *      加一个，tail++
 *      减一个，head++
 *  3、知道空队列和满队列的状态，
 *      最开始是空的，head和tail都在一起，为0
 *  4、需要转移数据的状态
 *      tail == n，并且head != 0,如果是0的话说明他已经满了，转移也没什么用了
 *
 * @author: JayChan
 * @date: 2021/6/24
 * @time: 3:18 下午
 * Copyright (C) 2015 xxx
 * All rights reserved
 */
public class ArrayQueue<T extends Object> {

    /** 数据存储 */
    private Object[] data;
    /**总大小*/
    private int count;
    /** 头标 */
    private int head;
    /** 尾标 */
    private int tail;

    /** init */
    public ArrayQueue(int count) {
        data = new Object[count];
        this.count = count;
    }

    /**
     * input
     * @param item  队列元素
     * @return 是否加入队列成功
     */
    public boolean enqueue(T item){
        //判断尾坐标是否超过队列长度
        if (tail == count){
            System.out.println("队列已满");
            return false;
        }
        //input queue
        data[tail] = item;
        tail++;
        //sout
        System.out.println("\\" + head + "\\" + tail);
        return true;
    }

    /**
     * input v2 根据情况进行自动重组
     * @param item
     * @return
     */
    public boolean enqueueAndReset(T item){
        if (tail == count){
            if (head == 0){
                System.out.println("queue is full");
                return false;
            }else{
                //queue is not full ,need to reset queue
                reset();
            }
            data[tail] = item;
            tail++;
            //sout
            System.out.println("\\" + head + "\\" + tail);
            return true;
        }

        return true;
    }

    /**
     * output
     *
     * @return 移除队列的元素
     */
    public T dequeue(){
        //queue is null?
        if (head == tail){
            System.out.println("queue is null");
            return  null;
        }
        T s = (T)data[head];
        head++;
        //sout
        System.out.println("\\" + head + "\\" + tail);
        return s;
    }

    /**
     * 队列自我重制
     */
    public void reset(){
        for (int i = head; i<tail; i++){
            data[i-head] = data[i];
        }
        tail = tail - head;
        head = 0;
        System.out.println("resetDate is "+"\\"+head+"\\"+tail);
    }


}
