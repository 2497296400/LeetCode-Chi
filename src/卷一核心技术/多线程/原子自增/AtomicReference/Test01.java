package 卷一核心技术.多线程.原子自增.AtomicReference;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/*使用 AtomicReference 原子读写一个对象*/
public class Test01 {
    //创建一个 AtomicReference 对象
    static AtomicReference<String> atomicReference = new AtomicReference<>("abc");
    public static void main(String[] args) throws InterruptedException {
        //创建 100 个线程修改字符串
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (atomicReference.compareAndSet("abc", "def")) {
                        System.out.println(Thread.currentThread().getName() + "把字符串abc 更改为 def");
                    }
                }
            }).start();
        }
        //再创建 100 个线程
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (atomicReference.compareAndSet("def", "abc")) {
                        System.out.println(Thread.currentThread().getName() + "把字符串还原为 abc");
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(atomicReference.get());
    }}
