package 手写一系列东西.CompletableFuture测试类.业务;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread()+"主线程执行开始");
        CompletableFuture<List<CompletableFuture<Void>>> listCompletableFuture =
                
                CompletableFuture.supplyAsync(FutureTest::getUserListIds)
                .thenApplyAsync(userIds -> userIds.stream()
                        .map(userId -> CompletableFuture
                                .supplyAsync(() -> getUserDetail(userId))
                                .thenAccept(msg-> System.out.println(msg)))
                        .collect(Collectors.toList())
                );
        
        mainThreadDo();
        
        listCompletableFuture.thenAccept(completableFutures -> {
            CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
            try {
                completableFuture.thenRun(FutureTest::mainThreadDo).get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).get();
        
       // Thread.sleep(20000);
        System.out.println(Thread.currentThread()+"主线程知执行结束");
    }

    public static void mainThreadDo() {
        System.out.println(Thread.currentThread() + "main thread strat");
        sleep();
        System.out.println(Thread.currentThread() + "main thread end");
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getUserListIds() {
        System.out.println(Thread.currentThread() + "获取IdsgetUserListIds");
        sleep();
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    public static String getUserDetail(Integer id) {
        System.out.println(Thread.currentThread() + "获取用户详情getUserDetail");
        sleep();
        return String.format("用户id:%d", id);
    }
}
