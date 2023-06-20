package 手写一系列东西.CompletableFuture测试类;

import java.util.concurrent.*;

public class CompleteFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return 1;
        });
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            System.out.println("saasd");
        });
        System.out.println(future.get());
        CompletableFuture<Integer> apply = future.thenApplyAsync((a) -> {
            System.out.println(Thread.currentThread().getName());
            return a + 5;
        }).thenApplyAsync((a)->{
            System.out.println(Thread.currentThread().getName());
            return a+5;
        }).handleAsync((a,e)-> a+10);
        System.out.println(future.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"  "+ apply.getNow(0));
        }).start();
        System.out.println(apply.getNow(0));
    }
}
