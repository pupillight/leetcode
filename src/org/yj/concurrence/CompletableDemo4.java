package org.yj.concurrence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableDemo4 {

    static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "yinjian");
        map.put(2, "zhangsan");
        map.put(3, "lisi");


    }

    public CompletableFuture<String> getUserName(int id) {
        return CompletableFuture.supplyAsync(() -> {
            String name = map.get(id);
            return name;
        });

    }


    public CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            String greet = "Hello: " + name;
            return greet;
        });
    }


    public String compose(int id) {
        CompletableFuture<String> f1 = this.getUserName(id);
        CompletableFuture<String> res = f1.thenCompose(name -> {
            CompletableFuture<String> future = sayHello(name);
            return future;
        });

        return res.join();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            return 10;
        }, executorService);
//                .whenComplete((res, error) -> System.out.println(res))
//                .exceptionally(e -> -1);
        //System.out.println(future1.join());


        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5;
        }, executorService);

/*        System.out.println(future1.thenCombineAsync(future2, (res1, res2) -> res1 + res2, executorService).join());

        future1.thenAcceptBothAsync(future2, (res1, res2) -> {
            System.out.println(res1);
            System.out.println(res2);
        }, executorService);*/

/*        future1.runAfterBoth(future2,()->System.out.println("-------"));
        future1.runAfterEither(future2,()-> System.out.println("------"));*/

     /*   future1.runAfterBoth(future2,()->System.out.println(Thread.currentThread().getName()));
        future1.runAfterBothAsync(future2, () -> {
            System.out.println("------");
            System.out.println(Thread.currentThread().getName());
        }, executorService);

        future1.runAfterEitherAsync(future2,()-> System.out.println(Thread.currentThread().getName()));*/
        //future1.thenAcceptBoth(future2,(res1,res2)-> System.out.println(res1*res2));
        /*CompletableFuture<Integer> future2 = future1.whenComplete((res, e) ->
                System.out.println(".......")).
                exceptionally((error) -> {
                    return -1;
                });

        System.out.println(future2.join());*/


        CompletableFuture<Integer> future3 = future1.thenCompose(res -> {

            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> res / 2);
            return future;
        });

        System.out.println(future3.join());
        //System.out.println(future1.applyToEitherAsync(future2, (t) -> t, executorService).join());
        // executorService.shutdown();


        CompletableDemo4 demo = new CompletableDemo4();
        System.out.println(demo.compose(1));

    }
}
