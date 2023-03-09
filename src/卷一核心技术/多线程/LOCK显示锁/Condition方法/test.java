package 卷一核心技术.多线程.LOCK显示锁.Condition方法;

import java.util.concurrent.locks.*;

/**
 * 使用 Condition 实现生产者/消费者设计模式, 两个线程交替打印
 */
public class test {
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

   static class MyService {
        private Lock lock = new ReentrantLock();
        //创建锁对象
        private  ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        private Condition conditionA = lock.newCondition(); //创建 Condition 对象
        private Condition conditionB = lock.newCondition(); //创建 Condition 对象
        private boolean flag = true;//定义交替打印标志
        //定义方法只打印----横线
        public void printOne() {
           try {
               lock.lock();
               while (flag){
                   System.out.println(Thread.currentThread().getName()+"等待中");
                   conditionA.await();
               }
               flag=true;
               System.out.println(Thread.currentThread().getName()+"------");
               conditionB.signal();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               lock.unlock();
           }
        }
        //定义方法只打印***横线
        public void printTwo() {
            try {
                lock.lock();
                while (!flag) {//当 flag 为 false 等待
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    conditionB.await();
                }//flag 为 true 时打印
                System.out.println(Thread.currentThread().getName() + " ****** ");
                flag = false;//修改交替打印标志
                conditionA.signal();//通知另外的线程打印
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//释放锁对象
            }
        }
    }
}