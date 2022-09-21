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
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //CompletableFuture<String> future = new CompletableFuture<>();
 /*       CompletableFuture<Integer> future1 = new CompletableFuture<Integer>().completeAsync((() ->
                new Random().nextInt(10)
        ), executorService);
        CompletableFuture<Integer> future2 = new CompletableFuture<Integer>().completeAsync((() ->
                new Random().nextInt(10)
        ), executorService);

        CompletableFuture<Integer> future = future1.thenCombineAsync(future2, (f1, f2) -> f1.intValue() * f2.intValue(), executorService);
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

       /* CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> new Random().nextInt(10), executorService);
        //CompletableFuture<Integer> future3= new CompletableFuture<Integer>().completeAsync(()->new Random().nextInt(10),executorService);
        // future3= future3.completeAsync(()->new Random().nextInt(10),executorService);
        try {
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

/*

        List<Integer> list = Arrays.asList(5, 9, 14);

        //List<Integer> newList =
                list.stream()
                .map(num -> CompletableFuture.supplyAsync(()->num*2,executorService))
                .map(future->future.thenApplyAsync(n->n*2))
                .map(future->future.join()).forEach(System.out::println);
        //newList.stream().forEach(System.out::println);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> new Random().nextInt(10), executorService);

        while (!future.isDone()) {
            System.out.println(future.join());
        }
*/

      /* CompletableFuture<Void> future= CompletableFuture.runAsync(()-> System.out.println("test"),executorService);

        System.out.println(future.isDone());

        //CompletableFuture<String> future1=CompletableFuture.completedFuture("hello").thenApplyAsync(message->message.toUpperCase());
        CompletableFuture<Void> future1=CompletableFuture.completedFuture("hello").thenAccept(System.out::println);
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/



        try {
            CompletableFuture<Integer> f= CompletableFuture.supplyAsync(()->{
                int a=10;
                int b=0;
                return a/b;
            },executorService);
            //CompletableFuture<Integer> future= f.handleAsync((num,u)->num*2,executorService);
            //future.get();
            //CompletableFuture<Integer> f2 =
            CompletableFuture<Integer> ff=   f.exceptionally(throwable -> {return Integer.MIN_VALUE;});
            //System.out.println(f.exceptionally((error)->error).get());
            System.out.println( ff.get());
        }
        catch (InterruptedException e) {
            //e.printStackTrace();
        } catch (ExecutionException e) {
            //e.printStackTrace();
        }
        catch (Exception e) {
           // e.printStackTrace();
        }

        executorService.shutdown();
    }
}
