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

        LinkedQueue<String> queue = new LinkedQueue<String>();
        System.out.println("input");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println("----------------------");
        System.out.println("output");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("----------------------");
        System.out.println("input again!");
        queue.enqueue("a");
        queue.enqueue("b");
    }
}
