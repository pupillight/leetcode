package org.yj.concurrence;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {

    //static AtomicInteger t = new AtomicInteger(0);

    static int t = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        /*ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor
                .schedule(() -> { System.out.println("Some Task"); }, 5, TimeUnit.SECONDS);*/

        Future<Integer> future = executor.submit(() -> new Random().nextInt(100));
        System.out.println("Before Cancel - Task is done : " + future.isDone());
        System.out.println("Before Cancel - Task is cancel : " + future.isCancelled());

        if (future.isDone() == false) {
            future.cancel(false);
        }

        System.out.println("Before Cancel - Task is done : " + future.isDone());
        System.out.println("Before Cancel - Task is cancel : " + future.isCancelled());

        executor.shutdown();


    }


}

abstract class DemoA {

}
