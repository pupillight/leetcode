package org.yj.concurrence.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {

            try {
                //String product = queue.take();
                String product =    queue.poll(100, TimeUnit.MILLISECONDS);
                System.out.println("consume product:"+product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
