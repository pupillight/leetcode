package org.yj.concurrence;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Future<String> future=  executorService.submit(()->System.out.println("current Thread ="+Thread.currentThread().getName()));
        // Future<?> future=  executorService.submit(()->System.out.println(Thread.currentThread().getName()));
        // executorService.execute(()->System.out.println("current Thread ="+Thread.currentThread().getName()));
        Random random = new Random();
        for (int i = 0; i < 5; i++) {

            Future<String> submit = executorService.submit(() -> Thread.currentThread().getName()+ "-"+random.nextInt(10));
            while (!submit.isDone()) {

                //System.out.println(submit.toString());
                System.out.println("------------" + submit.get());
            }
        }


        System.out.println("the main thread ends.");
        executorService.shutdown();

    }
}
