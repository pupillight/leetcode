package org.yj.concurrence;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreadPoolDemo {

    private int coreSize;
    private LinkedBlockingQueue<Runnable> queue;
    private Worker[] workers;

    public TreadPoolDemo(int coreSize) {
        this.coreSize = coreSize;
        workers = new Worker[coreSize];
        this.queue = new LinkedBlockingQueue<>();

        for (Worker worker : workers) {
            worker = new Worker(queue);
            worker.start();
        }
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
        }
    }

    public static void main(String[] args) {
        TreadPoolDemo demo = new TreadPoolDemo(5);
        demo.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}


class Worker extends Thread {
    LinkedBlockingQueue<Runnable> queue;

    public Worker(LinkedBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            while (!queue.isEmpty()) {
                Runnable runnable = queue.poll();
                if(runnable!=null){
                    runnable.run();
                }
            }
        }

    }
}
