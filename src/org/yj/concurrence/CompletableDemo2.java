package org.yj.concurrence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
      /*  CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int a = 10;
            int b = 2;
            return a / b;
        }, executorService)
                .whenComplete((res, error) -> System.out.println(res))
                .exceptionally(e -> -1);
        System.out.println(future1.join());*/


       /* CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            int a = 10;
            int b = 2;
            return a / b;
        }, executorService)
                .exceptionally((error) -> -1)
                .thenAcceptAsync((res) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(res);
                }, executorService);*/

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            int a = 10;
            int b = 0;
            return a / b;
        }, executorService)
                //.exceptionally(e->-1)
                .thenApplyAsync(res -> res * 10, executorService)
                .exceptionally(e -> Integer.MIN_VALUE);
        System.out.println(future2.join());



        /*CompletableFuture<Integer> future2 = future1.whenComplete((res, e) ->
                System.out.println(".......")).
                exceptionally((error) -> {
                    return -1;
                });

        System.out.println(future2.join());*/


        executorService.shutdown();


    }
}
