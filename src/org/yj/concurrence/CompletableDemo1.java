package org.yj.concurrence;

import org.yj.stream.Employee;
import org.yj.stream.Gender;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CompletableDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        CompletableFuture<String> f1 = CompletableFuture.completedFuture("message");
//        System.out.println(f1.join());
//
//        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
//            Random random = new Random();
//            int i = 0;
//            while (i < 10) {
//                System.out.println(random.nextInt(10));
//                i++;
//            }
//        });

        //------------------------------------ compose and combine-----------------------------------
/*
        CompletableFuture<String> f = supplyAsync(() -> {
            return "the chef  ";
        }, executorService).thenCompose(dish -> CompletableFuture.supplyAsync(() -> dish + "the waiter"));
        System.out.println(f.join());

        CompletableFuture<String> f2 = supplyAsync(() -> {
            return "the waiter ";
        }, executorService);*/

      /*  CompletableFuture<String> f1 = supplyAsync(() -> {
            return "the chef  ";
        }, executorService).thenComposeAsync(r -> {
            return CompletableFuture.supplyAsync(() -> {
                return r + "the waiter";
            });
        });


        System.out.println(f1.join());
        //System.out.println(f2.join());
        System.out.println("food is ready.");*/


        //-----------------------------------thenApply thenAccept thenRun----------------------------------
        //System.out.println(supplyAsync(() -> "the chef").thenCompose(r -> supplyAsync(() -> r + " the waiter")).join());
/*        supplyAsync(() -> 15)
                .thenApplyAsync(r -> r / 0)
                .thenApplyAsync(r -> r * 3)
                .handle((r, e) -> {
                    return Optional.ofNullable(e).isPresent() ? -1 : r;
                }).join();


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> new Employee("Jian", 45, Gender.MALE, 1000.0f)).thenApply(employee -> employee.getName());
        System.out.println(future.join());*/
        //CompletableFuture.supplyAsync(() -> 3).thenRun(()->System.out.println(Thread.currentThread().getName()));

        //CompletableFuture f2=CompletableFuture.supplyAsync(()->"the chef").thenApplyAsync(r->CompletableFuture.runAsync(()->System.out.println(r+"the waiter")));
        //f2.join();

        //-----------------------------------allOf anyOf----------------------------------


        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> System.out.println("hello"));
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> System.out.println("world"));
        CompletableFuture<Void> f3= CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("!");
        });

        CompletableFuture.allOf(f1,f2,f3).get();
        /*CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "world")
                .thenCombine(CompletableFuture.supplyAsync(()->"!"),(r1,r2)->r1+r2);
        System.out.println(f3.get());*/
        //System.out.println(f3.join());
       // CompletableFuture future= CompletableFuture.allOf(f1, f2);
       // System.out.println(future.get());

        //List<String> list =
        //System.out.println(Stream.of(f1, f2, f3).map(future -> future.join()).collect(Collectors.joining(" ")));
        //  System.out.println(list);


        executorService.shutdown();

    }
}
