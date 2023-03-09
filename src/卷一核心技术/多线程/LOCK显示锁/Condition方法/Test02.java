package 卷一核心技术.多线程.LOCK显示锁.Condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
    //1多个 Condition 实现通知部分线程, 使用更灵活
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
//开启两个线程,分别调用 waitMethodA(),waitMethodB()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodB();
            }
        }).start();
        Thread.sleep(3000);
//main 线程睡眠 3 秒
        service.signalA();
//唤醒 conditionA 对象上的等待,conditionB 上的等待依然继续等待
        service.signalB();
    }

    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        //定义锁对象
        //定义两个 Condtion 对象
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        //定义方法,使用 conditionA 等待
        public void waitMethodA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " begin wait:" + System.currentTimeMillis());
                conditionA.await();//等待
                System.out.println(Thread.currentThread().getName() + " end wait:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //定义方法,使用 conditionB 等待
        public void waitMethodB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " begin wait:" + System.currentTimeMillis());
                conditionB.await();//等待
                System.out.println(Thread.currentThread().getName() + " end wait:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //定义方法唤醒 conditionA 对象上的等待
        public void signalA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }

        //定义方法唤醒 conditionB 对象上的等待
        public void signalB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }
    }
}