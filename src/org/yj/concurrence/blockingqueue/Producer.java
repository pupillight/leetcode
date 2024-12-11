package org.yj.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        //while (true) {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put("Product:" + i);
                    System.out.println("create product:"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        //}

    }
}
