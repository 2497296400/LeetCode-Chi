package 卷一核心技术.多线程.原子自增;

import java.util.concurrent.atomic.AtomicInteger;

public class Test03 {
    public static void main(String[] args) {
//在 main 线程中创建 10 个子线程
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
    }

    static class MyThread extends Thread {
        //volatile 关键仅仅是表示所有线程从主内存读取 count 变量的值
        public static int count;

        /* 这段代码运行后不是线程安全的,想要线程安全,需要使用 synchronized 进行同
        步,如果使用 synchronized 同时,也就不需要 volatile 关键了
        public static void addCount(){
        for (int i = 0; i < 1000; i++) {
        //count++不是原子操作
        count++;
        }
        System.out.println(Thread.currentThread().getName() + " count=" + count); //输出的结构有非1000的倍数的数
        */
        public synchronized static void addCount() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " count=" + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}