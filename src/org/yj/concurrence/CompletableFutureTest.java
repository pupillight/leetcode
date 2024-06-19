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

            CompletableFuture<Void> f0 = CompletableFuture.runAsync(() -> {
                System.out.println("0000");
            });

            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("1111");
                return 1;
            });

            CompletableFuture.allOf(f0, f1).thenRun(() -> System.out.println("done")).join();
            //System.out.println(f1.get());
            //System.out.println(f1.join());
            //Thread.sleep(2000);
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
