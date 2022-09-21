package org.yj.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        /* Runnable runnable = () -> {
         *//*   try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
            System.out.println(Thread.currentThread().getName() );
            System.out.println("-------------");
        };

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(runnable, executorService);
        future1.whenCompleteAsync((res, e) -> {
            System.out.println(Thread.currentThread().getName() );
            System.out.println(res);
            System.out.println(e);
        }, executorService);*/


        //System.out.println("-----------------------------------------------");
       /* CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int a = 10;
            int b = 0;
            return a / b;
        }, executorService)
                .whenComplete((res, e) ->
                        System.out.println("......."))
                .exceptionally((error) -> {
                    return -1;
                });

        System.out.println(future1.join());*/

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int a = 10;
            int b = 2;
            return a / b;
        }, executorService)
                .whenComplete((res, error) -> System.out.println(res))
                .exceptionally(e -> -1);

        System.out.println(future1.join());
        /*CompletableFuture<Integer> future2 = future1.whenComplete((res, e) ->
                System.out.println(".......")).
                exceptionally((error) -> {
                    return -1;
                });

        System.out.println(future2.join());*/

      /*  CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int a = 10;
            int b = 0;
            return a / b;
        }, executorService).handleAsync((res, error) -> {
            System.out.println(res);
            System.out.println(error);
            return 55;
        }, executorService);

        System.out.println(future2.join());*/

        /*CompletableFuture<Integer> future3 =future2.handleAsync((res, exception) -> {
            //System.out.println(res);
            //System.out.println(exception);
            return Integer.MIN_VALUE;
        });*/
       /* future2.whenCompleteAsync((result, error) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
            System.out.println(error);
        }, executorService);
        future2.whenComplete((result, error) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
            System.out.println(error);
        });*/
        executorService.shutdown();


    }
}
