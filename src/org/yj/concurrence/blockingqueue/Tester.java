package org.yj.concurrence.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tester {

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(5);

       Thread producer = new Thread(new Producer(queue));
       Thread consumer = new Thread(new Consumer(queue));
       producer.start();
       consumer.start();
    }
}
