package 卷一核心技术.多线程.原子自增.CAS;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用原子变量类定义一个计数器
 * 该计数器,在整个程序中都能使用,并且所有的地方都使用这一个计数器,这个计数器可以设计为单例
 */
 class Indicator {
    //构造方法私有化
    private Indicator() {
    }

    //定义一个私有的本类静态的对象
    private static final Indicator INSTANCE = new Indicator();

    //3)提供一个公共静态方法返回该类唯一实例
    public static Indicator getInstance() {
        return INSTANCE;
    }//使用原子变量类保存请求总数,成功数,失败数

    private final AtomicLong requestCount = new AtomicLong(0); //记录请求总数
    private final AtomicLong successCount = new AtomicLong(0); //处理成功总数
    private final AtomicLong fialureCount = new AtomicLong(0); //处理失败总数

    //有新的请求
    public void newRequestReceive() {
        requestCount.incrementAndGet();
    }

    //处理成功
    public void requestProcessSuccess() {
        successCount.incrementAndGet();
    }

    //处理失败
    public void requestProcessFailure() {
        fialureCount.incrementAndGet();
    }

    //查看总数,成功数,失败数
    public long getRequestCount() {
        return requestCount.get();
    }

    public long getSuccessCount() {
        return successCount.get();
    }

    public long getFailureCount() {
        return fialureCount.get();
    }
}

//模拟服务器的请求总数, 处理成功数,处理失败数
public class Test {
    public static void main(String[] args) {
//通过线程模拟请求,在实际应用中可以在 ServletFilter 中调用 Indicator 计数器的相关方法
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Indicator.getInstance().newRequestReceive();//每个线程就是一个请求,请求总数要加 1
                    int num = new Random().nextInt();
                    if (num % 2 == 0) {
                        Indicator.getInstance().requestProcessSuccess();//偶数模拟成功
                    } else {
                        Indicator.getInstance().requestProcessFailure();//处理失败
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Indicator.getInstance().getRequestCount());
        System.out.println(Indicator.getInstance().getSuccessCount());
        System.out.println(Indicator.getInstance().getFailureCount());
    }
}