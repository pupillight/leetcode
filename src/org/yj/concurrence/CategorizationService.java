package org.yj.concurrence;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategorizationService {
    public static Category categorizeTransaction(Transaction transaction) {
        delay();
        return new Category("Category_" + transaction.getId());
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
/*
        List<Category> categories = Stream.of(new Transaction(1, "desc1"),
                new Transaction(2, "desc2"),
                new Transaction(3, "desc3"))
                .parallel()
                .map(transaction -> CategorizationService.categorizeTransaction(transaction))
                .collect(Collectors.toList());*/
        List<CompletableFuture<Category>> futures = Stream.of(new Transaction(1, "desc1"),
                new Transaction(2, "desc2"),
                new Transaction(3, "desc3"))
                .parallel()
                .map(transaction -> CompletableFuture.supplyAsync(() -> CategorizationService.categorizeTransaction(transaction)))
                .collect(Collectors.toList());

        List<Category> categories = futures.stream().map(f -> f.join()).collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.printf("The operation took %s ms%n", end - start);
        System.out.println("Categories are: " + categories);


    }
}

