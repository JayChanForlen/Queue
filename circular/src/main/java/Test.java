/**
 * @description:
 * @author: JayChan
 * @date: 2021/6/24
 * @time: 3:18 下午
 * Copyright (C) 2015 xxx
 * All rights reserved
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(
                "hello world!"
        );
        CircularQueue<String> queue = new CircularQueue<String>(3);
        queue.enqueue("a");//a
        queue.enqueue("b");//ab
        queue.dequeue();//a
        queue.enqueue("c");//ac
        queue.enqueue("d");//acd
        queue.dequeue();//ac
        queue.enqueue("e");//ace
        queue.enqueue("f");//ace
        queue.dequeue();//ac
        queue.enqueue("g");//acg
        queue.enqueue("h");//acg
        queue.dequeue();//ac
    }
}
