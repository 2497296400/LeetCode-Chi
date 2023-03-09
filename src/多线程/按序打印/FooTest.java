package 多线程.按序打印;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class FooTest {
    //利用原子数据结构
    //    class Foo {
//        private AtomicInteger first = new AtomicInteger(0);
//        private AtomicInteger second = new AtomicInteger(0);
//
//        public Foo() {
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            printFirst.run();
//            first.incrementAndGet();
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            while (first.get()!=1){
//
//            }
//
//            printSecond.run();
//            second.incrementAndGet();
//        }
//        public void third(Runnable printThird) throws InterruptedException {
//            // printThird.run() outputs "third". Do not change or remove this line.
//            while (second.get()!=1){
//
//            }
//            printThird.run();
//        }
//    }
    //利用锁
//    class Foo {
//          public Foo(){};
//          private boolean first;
//          private  boolean second;
//          public  Object lock=new Object();
//          public  void  first(Runnable printFirst) throws InterruptedException{
//              synchronized (lock){
//              printFirst.run();
//              first=true;
//              lock.notifyAll();
//          }
//
//
//    }
//    public  void seconde(Runnable printSecond)throws  InterruptedException{
//              synchronized (lock){
//                  while (!first){
//                      lock.wait();
//                  }
//                  printSecond.run();
//                  second=true;
//                  lock.notifyAll();
//              }
//    }
//    public  void  third(Runnable printThird)throws InterruptedException{
//              synchronized (lock){
//                  while (!second){
//                      lock.wait();
//                  }
//                  printThird.run();
//
//              }
//    }
//}

    //停车场同时容纳的车辆10
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        //模拟100辆车进入停车场
        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(() -> {
                try {
                    System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                    if (semaphore.availablePermits() == 0) {
                        System.out.println("车位不足，请耐心等待");
                    }
                    semaphore.acquire();//获取令牌尝试进入停车场
                    System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                    Thread.sleep(new Random().nextInt(10000));//模拟车辆在停车场停留的时间
                    System.out.println(Thread.currentThread().getName() + "驶出停车场");
                    semaphore.release();//释放令牌，腾出停车场车位
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "号车");

            thread.start();
        }

    }
}
