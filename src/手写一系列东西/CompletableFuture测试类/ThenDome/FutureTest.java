package 手写一系列东西.CompletableFuture测试类.ThenDome;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture =
                CompletableFuture.runAsync(FutureTest::cR);
        completableFuture.thenRun(() -> {
            System.out.println("1");
        });
        completableFuture.thenRun(() -> {
            System.out.println("2");
        });
        completableFuture.thenRun(() -> {
            System.out.println("3");
        });
        completableFuture.thenRun(() -> {
            System.out.println("4");
        });
        
        completableFuture.get();
    }

    public static void cR() {
        System.out.println(Thread.currentThread() + "主线程执行开始");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            
        }
        System.out.println(Thread.currentThread() + "主线程执行结束");
    }
}
