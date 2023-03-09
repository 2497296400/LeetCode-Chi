package 卷一核心技术.多线程.内部锁synchronized关键字;

//把整个静态方法体作为同步代码块,默认的锁对象是当前类的运行时类对象, Test06.class, 有人称它为类锁
public class Test06 {
    public static void main(String[] args) {
        Test06 obj = new Test06();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sm2();//使用的锁对象是 Test06.class
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test06.sm2();//使用的锁对象是 Test06.class
            }
        }).start();
    }
    //使用 synchronized 修饰静态方法,同步静态方法, 默认运行时类作为锁对象
    public synchronized static void sm2(){//synchronized（Test06.class）
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + i);
        }}}