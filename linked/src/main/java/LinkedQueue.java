/**
 * @description:
 *  1、首先需要有一个链表，即第一个参数为数据，第二个参数为下一个连标元素的地址，即new出来的医引用地址
 *  2、链表不需要考虑扩容问题，只需要考虑入队列和出队列的操作，牺牲了大小容量来获取了速度，这里并不去比较在链表中间读取元素的时间复杂度，因为队列不操作中间
 *  3、进入：首先要判断是不是首个元素，是的话首尾相等，不是的话要将tail后移
 *  4、取出：首先看是否为空，不为空的话将head后移并将之前的数据清除；
 * @author: JayChan
 * @date: 2021/6/24
 * @time: 5:23 下午
 * Copyright (C) 2015 xxx
 * All rights reserved
 */
public class LinkedQueue<T> {

    /**
     * 头元素
     */
    private Linked head;
    /**
     * 尾元素
     */
    private Linked tail;

    /**
     * input
     * 详情请看 入队列.jpg&入队列堆栈信息.png
     * @param item
     * @return 是否添加成功
     */
    public boolean enqueue(T item){
        if (head == null){
            Linked data = new Linked(item,null);
            head = data;
            tail = data;
            //第一个元素a，head和tail使用的同一个元素指针，即改变tail也会改变head
        }else{
            //1、第二个元素b--》将第二个元素的引用放在head和tail的next上，此时head和tail的next都是第二个元素的引用
            //2、第三个元素c--》此时head的第一个属性是头元素，第二个属性指向了tail，而tail的第一个属性是第二个元素，第二个元素指向了null
            //               new了第三个元素，将引用指向了tail的next属性，那么此时tail的next属性有了，那head中的第二个属性也是tail，那么他的next也会变
            //               也就是说head中有    data(a),next(data(b),next(data(c),next(null)))
            tail.next = new Linked(item,null);
            //1、第二个元素--》此时链表已经成型了，我们需要将尾巴给拿出来，而尾巴和我们之前那一步的next相同，也就是说这一句也可以使用head.next
            //2、第三个元素--》这一步只是单纯的将最后一个数据复制到tail上，而整条链在head那里，head中最里面的元素就是tail
            tail = tail.next;
        }
        System.out.println(head+"  \\  "+tail);
        return true;
    }

    public Object dequeue(){
        if (head == null){
            return "";
        }
        Object o = head.data;
        head = head.next;
        if (head == null){
            /**
             * 没有下一个元素了,如果不把tail置空再进入队列的话，若是没有head==null判断会有问题 <这个很重要>
             */
            tail = null;
        }
        System.out.println(head+"  \\  "+tail);
        return o;
    }

    /**
     * 用于保存队列中的元素
     */
    private static class Linked<T>{
        private T data;//数据
        private Linked next;//下一个元素的指针

        public Linked(T data, Linked next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Linked{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
