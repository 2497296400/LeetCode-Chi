package 卷一核心技术.多线程.内部锁synchronized关键字;

//如果线程的锁不同, 不能实现同步
public class Test02 {
    public static void main(String[] args) {
        Test02 obj = new Test02();
        Test02 obj2 = new Test02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象this就是obj对象
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();//使用的锁对象 this 也是 obj2对象
            }
        }).start();}
    public void mm(){
        synchronized ( this ) {//经常使用this当前对象作为锁对象
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }}}}