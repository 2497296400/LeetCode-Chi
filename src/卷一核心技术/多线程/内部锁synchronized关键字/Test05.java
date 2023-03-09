package 卷一核心技术.多线程.内部锁synchronized关键字;

//把整个方法体作为同步代码块,默认的锁对象是 this 对象
public class Test05 {
    public static void main(String[] args) {
        Test05 obj = new Test05();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm22();//使用的锁对象this就是obj对象
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm22();//使用的锁对象 this 也是 obj对象, 可以同步
                new Test05().mm22();
            }
        }).start(); }
    //使用 synchronized 修饰实例方法,同步实例方法, 默认 this 作为锁对象
    public synchronized void mm22(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + i);
        }}}