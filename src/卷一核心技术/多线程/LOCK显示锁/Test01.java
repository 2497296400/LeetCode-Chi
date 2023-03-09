package 卷一核心技术.多线程.LOCK显示锁;

public class Test01 {
    public synchronized void sm1(){
        System.out.println("同步方法 1");
        /*线程执行 sm1()方法,默认 this 作为锁对象,在 sm1()方法中调用了 sm2()方法,注意当前线程还是持有 this 锁对象的 sm2()同步方法默认的锁对象也是 this 对象, 要执行 sm2()必须先获得 this 锁对象,当前 this 对象被当前线程持有,可以 再次获得 this 对象, 这就是锁的可重入性. 假设锁不可重入的话,可能会造成死锁*/
        sm2();
    }
    private synchronized void sm2() {System.out.println("同步方法 2");}
    public static void main(String[] args) {
        Test01 obj = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.sm1();
            }
        }).start();
    }}