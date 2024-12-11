package org.yj.concurrence;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest {


    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(10);

           CompletableFuture<String> f1= CompletableFuture.supplyAsync(()->{
                return "a";
            }).thenApply(a-> a+"b");

            //CompletableFuture<String> f2= f1.thenCombine(CompletableFuture.supplyAsync(()->"c"),(s1,s2)->s1+s2);

            //System.out.println(f2.get());
            CompletableFuture<String> f2= CompletableFuture.supplyAsync(()->"c").thenCombine(CompletableFuture.supplyAsync(()->"d"),(s1,s2)->s1+s2);

            System.out.println(f1.thenCombine(f2, (s1, s2) -> s1 + s2));


/*            CompletableFuture<Integer> fc = CompletableFuture.supplyAsync(() -> {
                int t = new Random().nextInt(10);
                System.out.println(t);
                return t;
            }).thenApply(t -> t * 2);

            System.out.println(fc.get().intValue());*/
           /* CompletableFuture<Void> f0 = CompletableFuture.runAsync(() -> {
                System.out.println("0000");
            });

            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("1111");
                return 1;
            });

            CompletableFuture.allOf(f0, f1).thenRun(() -> System.out.println("done")).join();
            //System.out.println(f1.get());
            //System.out.println(f1.join());
            //Thread.sleep(2000);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }

        }

        System.out.println("----end------");


    }
}
