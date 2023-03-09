package 卷一核心技术.多线程.LOCK显示锁.Condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test03 {
    public static void main(String[] args) {
        MyService myService = new MyService();
//创建线程打印--
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    myService.printOne();
                }
            }
        }).start();
//创建线程打印**
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    myService.printTwo();
                }
            }
        }).start();
    }
}

class MyService {

    private Lock lock = new ReentrantLock();
    //创建锁对象
    private Condition condition = lock.newCondition(); //创建 Condition 对象
    private boolean flag = true;

    //定义交替打印标志
    //定义方法只打印----横线
    public void printOne() {
        try {
            lock.lock();
            while (flag) {//当 flag 为 true 等待
                System.out.println(Thread.currentThread().getName() + " waiting...");
                condition.await();
            }//flag 为 false 时打印
            System.out.println(Thread.currentThread().getName() + " ---------------- ");
            flag = true;//修改交替打印标志
            condition.signal();//通知另外的线程打印
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //定义方法只打印***横线
    public void printTwo() {
        try {
            lock.lock();
            while (!flag) {//当 flag 为 false 等待
                System.out.println(Thread.currentThread().getName() + " waiting...");
                condition.await();
            }//flag 为 true 时打印
            System.out.println(Thread.currentThread().getName() + " ****** ");
            flag = false;//修改交替打印标志
            condition.signal();//通知另外的线程打印
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁对象
        }
    }
}