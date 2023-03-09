package 卷一核心技术.多线程.内部锁synchronized关键字;

public class Test01 {//可以实现同步，锁相同

    public static void main(String[] args) {
        Test01 obj = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象this就是obj对象
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象this也是obj对象
            }
        }).start();
    }

    //定义方法,打印 100 行字符串
    public void mm() {
        synchronized (this) {//经常使用this当前对象作为锁对象
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }
}