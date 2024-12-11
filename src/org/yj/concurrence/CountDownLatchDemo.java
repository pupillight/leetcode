package org.yj.concurrence;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {

      /*  ExecutorService service = null;
        //CountDownLatch countDownLatch = new CountDownLatch(3);
        try {
            service = Executors.newFixedThreadPool(5);


            for (int i = 0; i < 10; i++) {
                Runnable runnable =()-> System.out.println(Thread.currentThread().getName());

                service.submit(runnable);
            }

            System.out.println(" -------------- ");

           // countDownLatch.wait();


        } catch (Exception e) {

        } finally {
            service.shutdown();
        }
*/

        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            try {
                latch.countDown();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1");
        });

        Thread t2 = new Thread(()->{
            try {
                latch.countDown();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2");
        });

        t1.start();
        t2.start();
        latch.await();
        System.out.println("-----end -------");
    }
}
