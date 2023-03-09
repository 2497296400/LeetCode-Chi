package 卷一核心技术.多线程.原子自增;

import java.util.concurrent.atomic.AtomicInteger;

//使用原子类进行自增
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
//在 main 线程中创建 10 个子线程
        for (int i = 0; i < 1000; i++) {
            new MyThread().start();
            Thread.sleep(1000);
            System.out.println(MyThread.count.get());
        }
    }

    static class MyThread extends Thread {
        //使用 AtomicInteger 对象
        private static AtomicInteger count = new AtomicInteger();

        public static void addCount() {
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();//自增的后缀形式
            }
            System.out.println(Thread.currentThread().getName() + " count=" + count.get());
        }

        @Override
        public void run() {
            addCount();
        }
    }
}