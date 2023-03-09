package 卷一核心技术.多线程.Volatile关键字;

/**
 * volatile 的作用可以强制线程从公共内存中读取变量的值,而不是从工作内存中读取
 */
public class Test02 {
    public static void main(String[] args) {
//创建 PrintString 对象
        PrintString printString = new PrintString();
//开启子线程,让子线程执行 printString 对象的 printStringMethod()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                printString.printStringMethod();
            }
        }).start();
//main 线程睡眠 1000 毫秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在 main 线程中修改打印标志");
        printString.setContinuePrint(false);
        //程序运行,查看在 main 线程中修改了打印标志之后 ,子线程打印是否可以结束打印
        //程序运行后, 可能会出现死循环情况
        //分析原因: main 线程修改了 printString 对象的打印标志后, 子线程读不到
        //解决办法: 使用 volatile 关键字修饰 printString 对象的打印标志.
        //volatile 的作用可以强制线程从公共内存中读取变量的值,而不是从工作内存中读取
    }

    static class PrintString {
        private volatile boolean continuePrint = true;
        public PrintString setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
            return this;
        }

        public void printStringMethod() {
            System.out.println(Thread.currentThread().getName() + "开始....");
            while (continuePrint) {
            }
            System.out.println(Thread.currentThread().getName() + "结束++++++++++++++");
        }
    }
}
