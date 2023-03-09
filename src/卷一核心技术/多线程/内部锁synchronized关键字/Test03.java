package 卷一核心技术.多线程.内部锁synchronized关键字;

// 使用一个常量对象作为锁对象(可以实现同步)
public class Test03 {
    public static void main(String[] args) {
        Test03 obj = new Test03();
        Test03 obj2 = new Test03();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象 OBJ 常量
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();//使用的锁对象 OBJ 常量
            }
        }).start(); }
    public static final Object OBJ = new Object();
    //定义一个常量,
    public static void mm(){
        synchronized ( OBJ ) {//使用一个常量对象作为锁对象
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            } }  }}