package org.yj.concurrence;

import java.util.concurrent.*;
import java.util.function.Function;

public class CompletableDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("11111111");
            return 10;
        }, executorService);

       // future1.thenAccept(t-> System.out.println(t));


        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("222222222");
            return 5;
        }, executorService);

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("333333333");
            return 3;
        }, executorService);

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);

        //System.out.println(future.thenApply(t -> t).join());
        future.thenAccept(t-> System.out.println(t));
        //System.out.println();
        //System.out.println("--------" + future.get());

        executorService.shutdown();


    }
}
