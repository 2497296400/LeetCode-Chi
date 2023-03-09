package 卷一核心技术.多线程.TheadLocal;

import java.util.Date;
import java.util.Random;

/**
 * ThreadLocal 初始值, 定义 ThreadLocal 类的子类,在子类中重写 initialValue()方法指定初始值,再第一次调用 get()方法不会返回 null
 */
//1) 定义 ThreadLocal 的子类
class SubThreadLocal extends ThreadLocal<Date> {
    // 重写 initialValue 方法,设置初始值
    @Override
    protected Date initialValue() {
        return new Date(System.currentTimeMillis() - 1000 * 60 * 15);
    }
}

public class Test03 {
    //直接使用自定义的 SubThreadLocal 对象
    static SubThreadLocal threadLocal = new SubThreadLocal();

    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        t1.start();
        SubThread t2 = new SubThread();
        t2.start();
    }

    //定义线程类
    static class SubThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //第一次调用 threadLocal 的 get()方法会返回 null
                System.out.println("---------" + Thread.currentThread().getName() + " value=" + threadLocal.get());
                //如果没有初始值就设置当前日期
                if (threadLocal.get() == null) {
                    System.out.println("*****************");
                    threadLocal.set(new Date());
                }
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
