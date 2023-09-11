package 手写一系列东西.一些列小测试;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                countDownLatch.countDown();
                System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
