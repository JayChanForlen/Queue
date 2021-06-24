import java.util.ArrayList;

/**
 * @description:
 * @author: JayChan
 * @date: 2021/6/24
 * @time: 3:18 下午
 * Copyright (C) 2015 Meituan
 * All rights reserved
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(
                "hello world!"
        );

        ArrayQueue<String> queue = new ArrayQueue<String>(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        //添加不进去了
        queue.enqueue("f");//-队列满
        queue.enqueueAndReset("f");//-full

        queue.dequeue();//a
        queue.dequeue();//b
        //需要重制
        queue.enqueue("f");//-队列满
        queue.enqueueAndReset("f");
    }
}
