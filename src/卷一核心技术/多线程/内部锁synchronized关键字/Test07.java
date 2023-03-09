package 卷一核心技术.多线程.内部锁synchronized关键字;

//同步方法与同步代码块如何选择 :同步方法锁的粒度粗, 执行效率低, 同步代码块执行效率高
public class Test07 {
    public static void main(String[] args) {
        Test07 obj = new Test07();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();}
    //同步方法, 执行效率低
    public synchronized void doLongTimeTask(){
        try {
            System.out.println("Task Begin");
            Thread.sleep(3000); //模拟任务需要准备 3 秒
            System.out.println("开始同步");
            for(int i = 1; i <= 100; i++){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
    //同步代码块,锁的粒度细, 执行效率高
    public void doLongTimeTask2(){
        try {
            System.out.println("Task Begin");
            Thread.sleep(3000);//模拟任务需要准备 3 秒
            synchronized (this){
                System.out.println("开始同步");
                for(int i = 1; i <= 100; i++){
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                } }
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}}
