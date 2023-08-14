package 手写一系列东西.限流算法.固定窗口限流;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 会导致 两个窗口中 后前相连请求多次 导致限流不稳定
 */
public class RaletimeLimitSimpleWindow {
    private static Integer QPS = 1;
    // 时间窗口
    private static long TIME_WINDOWS = 1000;
    private static AtomicInteger REQ_COUNT = new AtomicInteger(0);
    private static long START_TIME = System.currentTimeMillis();

    public synchronized static boolean limit() {
        long curTime = System.currentTimeMillis();
        if (curTime - START_TIME < TIME_WINDOWS) {
            REQ_COUNT.incrementAndGet();
            return REQ_COUNT.get() <= QPS;
        } else {
            START_TIME = curTime;
            REQ_COUNT.set(0);
            return true;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new Thread(() -> {
                boolean limit = limit();
                if (limit) {
                    System.out.println("正常访问");
                } else {
                    System.out.println("限流");
                }
            }).start();
        }
    }
}
