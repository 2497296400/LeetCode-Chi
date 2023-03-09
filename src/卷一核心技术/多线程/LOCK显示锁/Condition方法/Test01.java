package 卷一核心技术.多线程.LOCK显示锁.Condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
关键字 synchronized 与 wait()/notify()这两个方法一起使用可以实现等待/通知模式. Lock 锁的 newContition()方法返回 Condition 对象,Condition 类也可以实现等待/通知模式.

使用 notify()通知时, JVM 会随机唤醒某个等待的线程. 使用 Condition 类可以进行选择性通知. Condition 比较常用的两个方法:

await()会使当前线程等待,同时会释放锁,
当其他线程调用 signal() 时,线程会重新获得锁并继续执行. signal()用于唤醒一个等待的线程
注意:

在调用 Condition 的 await()/signal()方法前,也需要线程持有相关的 Lock 锁. 调用 await()后线程会释放这个锁,在 singal()调用后会从当前 Condition 对象的等待队列中,唤醒 一个线程,唤醒的线程尝试获得锁, 一旦获得锁成功就继续执行
 */
/* Condition 等待与通知*/
public class Test01 {
    //定义锁
    static Lock lock = new ReentrantLock();
    //获得 Condtion 对象
    static Condition condition = lock.newCondition();

    static class SubThread extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();//在调用 await()前必须先获得锁
                System.out.println("method lock");
                condition.await();//等待
                System.out.println("method await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//释放锁
                System.out.println("method unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        t.start();//子线程启动后,会转入等待状态
        Thread.sleep(3000);//主线程在睡眠 3 秒后,唤醒子线程的等待
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}