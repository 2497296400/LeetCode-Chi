package 卷一核心技术.多线程.线程池;

import java.util.Random;
import java.util.concurrent.*;

/* 自定义拒绝策略*/
public class Test03 {
    public static void main(String[] args) {
        //定义任务
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int num = new Random().nextInt(5);
                System.out.println(Thread.currentThread().getId() + "--" + System.currentTimeMillis() + "开始睡眠" + num + "秒");
                try {
                    TimeUnit.SECONDS.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //创建线程池, 自定义拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), (r1, executor) -> {
            //r就是请求的任务, executor就是当前线程池
            System.out.println(r1 + " is discarding..");
        });
        //向线程池提交若干任务
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            threadPoolExecutor.submit(r);
        }
    }
}